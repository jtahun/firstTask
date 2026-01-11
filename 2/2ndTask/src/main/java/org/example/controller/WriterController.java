package ru.igor.crud.controller;

import ru.igor.crud.exception.DeletedEntityException;
import ru.igor.crud.exception.NotFoundException;
import ru.igor.crud.exception.ValidationException;
import ru.igor.crud.model.Status;
import ru.igor.crud.model.Writer;
import ru.igor.crud.repository.post.PostRepository;
import ru.igor.crud.repository.writer.WriterRepository;

import java.util.List;
import java.util.stream.Collectors;

public class WriterController {
    private final WriterRepository writerRepository;
    private final PostRepository postRepository;

    public WriterController(WriterRepository writerRepository, PostRepository postRepository) {
        this.writerRepository = writerRepository;
        this.postRepository = postRepository;
    }

    public Writer create(String firstName, String lastName, List<Long> postIds) {
        validateName(firstName, "firstName");
        validateName(lastName, "lastName");

        if (postIds != null) {
            // проверяем, что посты существуют и ACTIVE
            for (Long postId : postIds) {
                var post = postRepository.findById(postId).orElseThrow(
                        () -> new ValidationException("Post id=" + postId + " не найден"));
                if (post.getStatus() == Status.DELETED) {
                    throw new ValidationException("Post id=" + postId + " имеет статус DELETED");
                }
            }
        }

        Writer w = new Writer();
        w.setFirstName(firstName);
        w.setLastName(lastName);
        w.setPostIds(postIds);
        w.setStatus(Status.ACTIVE);
        return writerRepository.save(w);
    }

    public Writer getById(long id) {
        return writerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Writer id=" + id + " не найден"));
    }

    public List<Writer> listAll() {
        return writerRepository.findAll();
    }

    public List<Writer> listActive() {
        return writerRepository.findAll().stream()
                .filter(w -> w.getStatus() == Status.ACTIVE)
                .collect(Collectors.toList());
    }

    public Writer update(long id, String firstName, String lastName, List<Long> postIds) {
        Writer existing = getById(id);
        if (existing.getStatus() == Status.DELETED) {
            throw new DeletedEntityException("Writer id=" + id + " удалён (DELETED), редактирование запрещено");
        }

        if (firstName != null && !firstName.isBlank()) {
            validateName(firstName, "firstName");
            existing.setFirstName(firstName);
        }
        if (lastName != null && !lastName.isBlank()) {
            validateName(lastName, "lastName");
            existing.setLastName(lastName);
        }
        if (postIds != null) {
            for (Long postId : postIds) {
                var post = postRepository.findById(postId).orElseThrow(
                        () -> new ValidationException("Post id=" + postId + " не найден"));
                if (post.getStatus() == Status.DELETED) {
                    throw new ValidationException("Post id=" + postId + " имеет статус DELETED");
                }
            }
            existing.setPostIds(postIds);
        }

        writerRepository.update(existing);
        return existing;
    }

    public void delete(long id) {
        Writer existing = getById(id);
        if (existing.getStatus() == Status.DELETED) {
            return; // уже удалён
        }
        existing.setStatus(Status.DELETED);
        writerRepository.update(existing);
    }

    private void validateName(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new ValidationException(field + " не должен быть пустым");
        }
    }
}
