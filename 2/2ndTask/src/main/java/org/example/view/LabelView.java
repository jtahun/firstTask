package org.example.view;

import org.example.controller.LabelController;

import java.util.List;
import java.util.Scanner;

public class LabelView {
    private final LabelController labelController;
    private final Scanner scanner;

    public LabelView(Scanner scanner) {
        this.labelController = new LabelController();
        this.scanner = scanner;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== Label Management ===");
            System.out.println("1. Create Label");
            System.out.println("2. View All Labels");
            System.out.println("3. View Label by ID");
            System.out.println("4. Update Label");
            System.out.println("5. Delete Label");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createLabel();
                case 2 -> viewAllLabels();
                case 3 -> viewLabelById();
                case 4 -> updateLabel();
                case 5 -> deleteLabel();
                case 6 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void createLabel() {
        System.out.print("Enter label name: ");
        String name = scanner.nextLine();

        var label = labelController.createLabel(name);
        System.out.println("Label created: " + label);
    }

    private void viewAllLabels() {
        var labels = labelController.getAllLabels();
        if (labels.isEmpty()) {
            System.out.println("No labels found.");
        } else {
            labels.forEach(System.out::println);
        }
    }

    private void viewLabelById() {
        System.out.print("Enter label ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        var label = labelController.getLabelById(id);
        if (label == null) {
            System.out.println("Label not found.");
        } else {
            System.out.println(label);
        }
    }

    private void updateLabel() {
        System.out.print("Enter label ID to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter new label name: ");
        String name = scanner.nextLine();

        try {
            var label = labelController.updateLabel(id, name);
            System.out.println("Label updated: " + label);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteLabel() {
        System.out.print("Enter label ID to delete: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {
            labelController.deleteLabel(id);
            System.out.println("Label deleted successfully.");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}