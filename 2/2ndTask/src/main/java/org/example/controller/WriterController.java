package org.example.controller;

import org.example.model.Post;
import org.example.model.Writer;
import org.example.repository.WriterRepository;
import org.example.repository.impl.GsonWriterRepositoryImpl;

import java.util.List;

public class WriterController {
    private final WriterRepository writerRepository;
    private final PostController postController;

    public WriterController() {
        this.writerRepository = new GsonWriterRepositoryImpl();
        this.postController = new PostController();
    }

    public Writer getWriterById(Long id) {
        return writerRepository.getById(id);
    }

    public List<Writer> getAllWriters() {
        return writerRepository.getAll();
    }

    public Writer createWriter(String firstName, String lastName, List<Long> postIds) {
        Writer writer = new Writer();
        writer.setFirstName(firstName);
        writer.setLastName(lastName);

        for (Long postId : postIds) {
            Post post = postController.getPostById(postId);
            if (post != null) {
                writer.getPosts().add(post);
            }
        }

        return writerRepository.save(writer);
    }

    public Writer updateWriter(Long id, String firstName, String lastName, List<Long> postIds) {
        Writer writer = writerRepository.getById(id);
        if (writer == null) {
            throw new RuntimeException("Writer not found with id: " + id);
        }

        writer.setFirstName(firstName);
        writer.setLastName(lastName);
        writer.getPosts().clear();

        for (Long postId : postIds) {
            Post post = postController.getPostById(postId);
            if (post != null) {
                writer.getPosts().add(post);
            }
        }

        return writerRepository.update(writer);
    }

    public void deleteWriter(Long id) {
        writerRepository.deleteById(id);
    }
}