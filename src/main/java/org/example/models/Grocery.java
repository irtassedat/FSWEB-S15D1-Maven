package org.example.models;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;



public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("Enter your choice: (0 to quit, 1 to add, 2 to remove)");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter items to add (separate multiple items with a comma): ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;
                case 2:
                    System.out.println("Enter items to remove (separate multiple items with a comma): ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;
            }
            printSorted();
        }
        scanner.close();
    }

    public static void addItems(String input) {
        Arrays.stream(input.split(","))
                .map(String::trim)
                .distinct() // Tekrarlanan girdileri kaldır
                .filter(item -> !item.isEmpty() && !groceryList.contains(item))
                .forEach(groceryList::add);
        Collections.sort(groceryList);
    }


    public static void removeItems(String input) {
        Arrays.stream(input.split(","))
                .map(String::trim)
                .distinct() // Tekrarlanan girdileri kaldır
                .forEach(item -> groceryList.remove(item));
        Collections.sort(groceryList);
    }


    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList); // Listenin kalıcı olarak sıralanmasını sağla ama mantıklı mı ?
        for (String item : groceryList) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        startGrocery();
    }
}
