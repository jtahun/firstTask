package org.example.repository.impl;


import org.example.model.Writer;
import org.example.model.Status;
import org.example.repository.WriterRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonWriterRepositoryImpl implements WriterRepository {
    private static final String FILE_PATH = "src/main/resources/writers.json";
    private final Gson gson = new Gson();

    private List<Writer> loadWriters() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<Writer>>(){}.getType();
            List<Writer> writers = gson.fromJson(reader, listType);
            return writers != null ? writers : new ArrayList<>();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException("Error reading writers file", e);
        }
    }

    private void saveWriters(List<Writer> writers) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(writers, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing writers file", e);
        }
    }

    private  Long generateId() {
        List<Writer> writers = loadWriters();
        if (writers.isEmpty()) {
            return 1L;
        }
        Long maxId = writers.stream()
                .mapToLong(Writer::getId)
                .max()
                .orElse(0L);
        return maxId + 1;
    }

    @Override
    public Writer getById(Long id) {
        List<Writer> writers = loadWriters();
        return writers.stream()
                .filter(writer -> writer.getId().equals(id) && writer.getStatus() == Status.ACTIVE)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writers = loadWriters();
        return writers.stream()
                .filter(writer -> writer.getStatus() == Status.ACTIVE)
                .toList();
    }

    @Override
    public Writer save(Writer writer) {
        List<Writer> writers = loadWriters();
        writer.setId(generateId());
        writers.add(writer);
        saveWriters(writers);
        return writer;
    }

    @Override
    public Writer update(Writer updatedWriter) {
        List<Writer> writers = loadWriters();
        for (int i = 0; i < writers.size(); i++) {
            if (writers.get(i).getId().equals(updatedWriter.getId())) {
                writers.set(i, updatedWriter);
                saveWriters(writers);
                return updatedWriter;
            }
        }
        throw new RuntimeException("Writer not found with id: " + updatedWriter.getId());
    }

    @Override
    public void deleteById(Long id) {
        List<Writer> writers = loadWriters();
        for (Writer writer : writers) {
            if (writer.getId().equals(id)) {
                writer.setStatus(Status.DELETED);
                saveWriters(writers);
                return;
            }
        }
        throw new RuntimeException("Writer not found with id: " + id);
    }
}
