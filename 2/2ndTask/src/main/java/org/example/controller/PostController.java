package org.example.controller;

import org.example.model.Label;
import org.example.model.Post;
import org.example.repository.PostRepository;
import org.example.repository.impl.GsonPostRepositoryImpl;

import java.util.List;

public class PostController {
    private final PostRepository postRepository;
    private final LabelController labelController;

    public PostController() {
        this.postRepository = new GsonPostRepositoryImpl();
        this.labelController = new LabelController();
    }

    public Post getPostById(Long id) {
        return postRepository.getById(id);
    }

    public List<Post> getAllPosts() {
        return postRepository.getAll();
    }

    public Post createPost(String title, String content, List<Long> labelIds) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);

        for (Long labelId : labelIds) {
            Label label = labelController.getLabelById(labelId);
            if (label != null) {
                post.getLabels().add(label);
            }
        }

        return postRepository.save(post);
    }

    public Post updatePost(Long id, String title, String content, List<Long> labelIds) {
        Post post = postRepository.getById(id);
        if (post == null) {
            throw new RuntimeException("Post not found with id: " + id);
        }

        post.setTitle(title);
        post.setContent(content);
        post.getLabels().clear();

        for (Long labelId : labelIds) {
            Label label = labelController.getLabelById(labelId);
            if (label != null) {
                post.getLabels().add(label);
            }
        }

        return postRepository.update(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}