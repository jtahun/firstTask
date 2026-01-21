package org.example;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Тестовые случаи
        String[] testCases = {"HOH", "OOHHHH", "HHHHHHOOO", "OHOHHH"};

        for (String water : testCases) {
            System.out.println("Тестируем строку: " + water);
            testH2O(water);
            System.out.println("=".repeat(40));
        }
    }
    private static void testH2O(String water){

    }
}


