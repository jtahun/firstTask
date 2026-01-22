package org.example;


import org.example.watergenapp.H2O;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

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
    private static void testH2O(String water) throws InterruptedException {
      H2O h2o = new H2O();
      StringBuilder result = new StringBuilder();

      ExecutorService executor = newFixedThreadPool(water.length());
      executor.shutdown();
      executor.awaitTermination(5, TimeUnit.SECONDS);

      String output = result.toString();
      System.out.println("Result: " + output);

      if(isValidWaterMolecules(output)){

      }
    }

    private static boolean isValidWaterMolecules(String output) {
        return true;
    }
}


