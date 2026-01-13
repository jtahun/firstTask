package org.example.repository.impl;

import org.example.model.Label;
import org.example.model.Post;
import org.example.model.Status;
import org.example.repository.PostRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class GsonPostRepositoryImpl implements PostRepository {
    private static final String FILE_PATH = "src/main/resources/posts.json";
    private final Gson gson = new Gson();

    private List<Post> loadPosts() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<Post>>(){}.getType();
            List<Post> posts = gson.fromJson(reader, listType);
            return posts != null ? posts : new ArrayList<>();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException("Error reading posts file", e);
        }
    }

    private void savePosts(List<Post> posts) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(posts, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing posts file", e);
        }
    }

    private synchronized Long generateId() {
        List<Post> posts = loadPosts();
        if (posts.isEmpty()) {
            return 1L;
        }
        Long maxId = posts.stream()
                .mapToLong(Post::getId)
                .max()
                .orElse(0L);
        return maxId + 1;
    }

    @Override
    public Post getById(Long id) {
        List<Post> posts = loadPosts();
        return posts.stream()
                .filter(post -> post.getId().equals(id) && post.getStatus() == Status.ACTIVE)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = loadPosts();
        return posts.stream()
                .filter(post -> post.getStatus() == Status.ACTIVE)
                .toList();
    }

    @Override
    public Post save(Post post) {
        List<Post> posts = loadPosts();
        post.setId(generateId());
        posts.add(post);
        savePosts(posts);
        return post;
    }

    @Override
    public Post update(Post updatedPost) {
        List<Post> posts = loadPosts();
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId().equals(updatedPost.getId())) {
                posts.set(i, updatedPost);
                savePosts(posts);
                return updatedPost;
            }
        }
        throw new RuntimeException("Post not found with id: " + updatedPost.getId());
    }

    @Override
    public void deleteById(Long id) {
        List<Post> posts = loadPosts();
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                post.setStatus(Status.DELETED);
                savePosts(posts);
                return;
            }
        }
        throw new RuntimeException("Post not found with id: " + id);
    }
}