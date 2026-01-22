package org.example;


import org.example.watergenapp.H2O;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

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
      H2O h2o = new H2O();
      StringBuilder sb = new StringBuilder();

      ExecutorService executor = newFixedThreadPool(water.length());

    }
}


