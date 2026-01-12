package org.example.view;

import org.example.controller.WriterController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriterView {
    private final WriterController writerController;
    private final Scanner scanner;

    public WriterView(Scanner scanner) {
        this.writerController = new WriterController();
        this.scanner = scanner;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== Writer Management ===");
            System.out.println("1. Create Writer");
            System.out.println("2. View All Writers");
            System.out.println("3. View Writer by ID");
            System.out.println("4. Update Writer");
            System.out.println("5. Delete Writer");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createWriter();
                case 2 -> viewAllWriters();
                case 3 -> viewWriterById();
                case 4 -> updateWriter();
                case 5 -> deleteWriter();
                case 6 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void createWriter() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        List<Long> postIds = getPostIds();

        var writer = writerController.createWriter(firstName, lastName, postIds);
        System.out.println("Writer created: " + writer);
    }

    private void viewAllWriters() {
        var writers = writerController.getAllWriters();
        if (writers.isEmpty()) {
            System.out.println("No writers found.");
        } else {
            writers.forEach(System.out::println);
        }
    }

    private void viewWriterById() {
        System.out.print("Enter writer ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        var writer = writerController.getWriterById(id);
        if (writer == null) {
            System.out.println("Writer not found.");
        } else {
            System.out.println(writer);
        }
    }

    private void updateWriter() {
        System.out.print("Enter writer ID to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter new first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter new last name: ");
        String lastName = scanner.nextLine();

        List<Long> postIds = getPostIds();

        try {
            var writer = writerController.updateWriter(id, firstName, lastName, postIds);
            System.out.println("Writer updated: " + writer);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteWriter() {
        System.out.print("Enter writer ID to delete: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {
            writerController.deleteWriter(id);
            System.out.println("Writer deleted successfully.");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private List<Long> getPostIds() {
        List<Long> postIds = new ArrayList<>();
        System.out.println("Enter post IDs (separated by space, press Enter to finish): ");
        String input = scanner.nextLine();

        if (!input.trim().isEmpty()) {
            String[] ids = input.split(" ");
            for (String id : ids) {
                try {
                    postIds.add(Long.parseLong(id));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID: " + id);
                }
            }
        }

        return postIds;
    }
}