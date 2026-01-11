package ru.igor.crud.controller;

import ru.igor.crud.exception.DeletedEntityException;
import ru.igor.crud.exception.NotFoundException;
import ru.igor.crud.exception.ValidationException;
import ru.igor.crud.model.Label;
import ru.igor.crud.model.Status;
import ru.igor.crud.repository.label.LabelRepository;

import java.util.List;
import java.util.stream.Collectors;

public class LabelController {
    private final LabelRepository labelRepository;

    public LabelController(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public Label create(String name) {
        validateNotBlank(name, "name");
        Label l = new Label();
        l.setName(name);
        l.setStatus(Status.ACTIVE);
        return labelRepository.save(l);
    }

    public Label getById(long id) {
        return labelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Label id=" + id + " не найден"));
    }

    public List<Label> listAll() {
        return labelRepository.findAll();
    }

    public List<Label> listActive() {
        return labelRepository.findAll().stream()
                .filter(l -> l.getStatus() == Status.ACTIVE)
                .collect(Collectors.toList());
    }

    public Label update(long id, String name) {
        Label existing = getById(id);
        if (existing.getStatus() == Status.DELETED) {
            throw new DeletedEntityException("Label id=" + id + " удалён (DELETED), редактирование запрещено");
        }
        if (name != null && !name.isBlank()) {
            validateNotBlank(name, "name");
            existing.setName(name);
        }
        labelRepository.update(existing);
        return existing;
    }

    public void delete(long id) {
        Label existing = getById(id);
        if (existing.getStatus() == Status.DELETED) return;
        existing.setStatus(Status.DELETED);
        labelRepository.update(existing);
    }

    private void validateNotBlank(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new ValidationException(field + " не должен быть пустым");
        }
    }
}
