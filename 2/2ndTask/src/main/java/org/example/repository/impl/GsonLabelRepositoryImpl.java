package org.example.repository.impl;

import org.example.model.Label;
import org.example.model.Status;
import org.example.repository.LabelRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private static final String FILE_PATH = "src/main/resources/labels.json";
    private final Gson gson = new Gson();

    private List<Label> loadLabels() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<Label>>(){}.getType();
            List<Label> labels = gson.fromJson(reader, listType);
            return labels != null ? labels : new ArrayList<>();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException("Error reading labels file", e);
        }
    }

    private void saveLabels(List<Label> labels) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(labels, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing labels file", e);
        }
    }

    private synchronized Long generateId() {
        List<Label> labels = loadLabels();
        if (labels.isEmpty()) {
            return 1L;
        }
        Long maxId = labels.stream()
                .mapToLong(Label::getId)
                .max()
                .orElse(0L);
        return maxId + 1;
    }

    @Override
    public Label getById(Long id) {
        List<Label> labels = loadLabels();
        return labels.stream()
                .filter(label -> label.getId().equals(id) && label.getStatus() == Status.ACTIVE)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Label> getAll() {
        List<Label> labels = loadLabels();
        return labels.stream()
                .filter(label -> label.getStatus() == Status.ACTIVE)
                .toList();
    }

    @Override
    public Label save(Label label) {
        List<Label> labels = loadLabels();
        label.setId(generateId());
        labels.add(label);
        saveLabels(labels);
        return label;
    }

    @Override
    public Label update(Label updatedLabel) {
        List<Label> labels = loadLabels();
        for (int i = 0; i < labels.size(); i++) {
            if (labels.get(i).getId().equals(updatedLabel.getId())) {
                labels.set(i, updatedLabel);
                saveLabels(labels);
                return updatedLabel;
            }
        }
        throw new RuntimeException("Label not found with id: " + updatedLabel.getId());
    }

    @Override
    public void deleteById(Long id) {
        List<Label> labels = loadLabels();
        for (Label label : labels) {
            if (label.getId().equals(id)) {
                label.setStatus(Status.DELETED);
                saveLabels(labels);
                return;
            }
        }
        throw new RuntimeException("Label not found with id: " + id);
    }
}