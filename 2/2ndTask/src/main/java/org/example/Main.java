package org.example;

import org.example.view.LabelView;
import org.example.view.PostView;
import org.example.view.WriterView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LabelView labelView = new LabelView(scanner);
        PostView postView = new PostView(scanner);
        WriterView writerView = new WriterView(scanner);

        while (true) {
            System.out.println("\n=== CRUD Console Application ===");
            System.out.println("1. Действия с Labels");
            System.out.println("2. Действия с Posts");
            System.out.println("3. Действия с Writers");
            System.out.println("4. Выход");
            System.out.print("Выбери действие: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // clear invalid input
                continue;
            }

            switch (choice) {
                case 1 -> labelView.showMenu();
                case 2 -> postView.showMenu();
                case 3 -> writerView.showMenu();
                case 4 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option! Нужно выбрать 1-4.");
            }
        }
    }
}