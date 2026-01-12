package org.example.view;

import org.example.controller.PostController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostView {
    private final PostController postController;
    private final Scanner scanner;

    public PostView(Scanner scanner) {
        this.postController = new PostController();
        this.scanner = scanner;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== Post Management ===");
            System.out.println("1. Create Post");
            System.out.println("2. View All Posts");
            System.out.println("3. View Post by ID");
            System.out.println("4. Update Post");
            System.out.println("5. Delete Post");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createPost();
                case 2 -> viewAllPosts();
                case 3 -> viewPostById();
                case 4 -> updatePost();
                case 5 -> deletePost();
                case 6 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void createPost() {
        System.out.print("Enter post title: ");
        String title = scanner.nextLine();

        System.out.print("Enter post content: ");
        String content = scanner.nextLine();

        List<Long> labelIds = getLabelIds();

        var post = postController.createPost(title, content, labelIds);
        System.out.println("Post created: " + post);
    }

    private void viewAllPosts() {
        var posts = postController.getAllPosts();
        if (posts.isEmpty()) {
            System.out.println("No posts found.");
        } else {
            posts.forEach(System.out::println);
        }
    }

    private void viewPostById() {
        System.out.print("Enter post ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        var post = postController.getPostById(id);
        if (post == null) {
            System.out.println("Post not found.");
        } else {
            System.out.println(post);
        }
    }

    private void updatePost() {
        System.out.print("Enter post ID to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter new post title: ");
        String title = scanner.nextLine();

        System.out.print("Enter new post content: ");
        String content = scanner.nextLine();

        List<Long> labelIds = getLabelIds();

        try {
            var post = postController.updatePost(id, title, content, labelIds);
            System.out.println("Post updated: " + post);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deletePost() {
        System.out.print("Enter post ID to delete: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {
            postController.deletePost(id);
            System.out.println("Post deleted successfully.");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private List<Long> getLabelIds() {
        List<Long> labelIds = new ArrayList<>();
        System.out.println("Enter label IDs (separated by space, press Enter to finish): ");
        String input = scanner.nextLine();

        if (!input.trim().isEmpty()) {
            String[] ids = input.split(" ");
            for (String id : ids) {
                try {
                    labelIds.add(Long.parseLong(id));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID: " + id);
                }
            }
        }

        return labelIds;
    }
}