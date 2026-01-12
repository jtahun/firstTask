package org.example.controller;

import org.example.model.Label;
import org.example.repository.LabelRepository;
import org.example.repository.impl.GsonLabelRepositoryImpl;

import java.util.List;

public class LabelController {
    private final LabelRepository labelRepository;

    public LabelController() {
        this.labelRepository = new GsonLabelRepositoryImpl();
    }

    public Label getLabelById(Long id) {
        return labelRepository.getById(id);
    }

    public List<Label> getAllLabels() {
        return labelRepository.getAll();
    }

    public Label createLabel(String name) {
        Label label = new Label();
        label.setName(name);
        return labelRepository.save(label);
    }

    public Label updateLabel(Long id, String name) {
        Label label = labelRepository.getById(id);
        if (label == null) {
            throw new RuntimeException("Label not found with id: " + id);
        }
        label.setName(name);
        return labelRepository.update(label);
    }

    public void deleteLabel(Long id) {
        labelRepository.deleteById(id);
    }
}