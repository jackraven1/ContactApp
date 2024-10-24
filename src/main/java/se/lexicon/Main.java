package se.lexicon;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Test: Set initial names
        String[] initialNames = {"Jack Raven", "Jari Test", "Jean Max"};
        NameRepository.setNames(initialNames);
        System.out.println("Initial names set: " + Arrays.toString(NameRepository.findAll()));

        // Test: Get size of names
        int size = NameRepository.getSize();
        System.out.println("Initial size of names: " + size);

        // Test: Add a new name
        String newName = "Amer Win";
        boolean added = NameRepository.add(newName);
        System.out.println("Add 'Amer Win': " + (added ? "Success" : "Failed"));

        // Test: Find a name
        String foundName = NameRepository.find("Jack Raven");
        System.out.println("Find 'Jack Raven': " + (foundName != null ? foundName : "Not Found"));

        // Test: Find by first name
        String[] foundByFirstName = NameRepository.findByFirstName("Jari");
        System.out.println("Find by first name 'Jari': " + Arrays.toString(foundByFirstName));

        // Test: Find by last name
        String[] foundByLastName = NameRepository.findByLastName("Max");
        System.out.println("Find by last name 'Max': " + Arrays.toString(foundByLastName));

        // Test: Update a name
        boolean updated = NameRepository.update("Jack Raven", "Jack Smith");
        System.out.println("Update 'Jack Raven' to 'Jack Smith': " + (updated ? "Success" : "Failed"));
        System.out.println("Names after update: " + Arrays.toString(NameRepository.findAll()));

        // Test: Remove a name
        boolean removed = NameRepository.remove("Jari Test");
        System.out.println("Remove 'Jari Test': " + (removed ? "Success" : "Failed"));
        System.out.println("Names after removal: " + Arrays.toString(NameRepository.findAll()));

        // Test: Get size of names after updates
        size = NameRepository.getSize();
        System.out.println("Size of names after operations: " + size);

        // Test: Clear names
        NameRepository.clear();
        System.out.println("Names after clearing: " + Arrays.toString(NameRepository.findAll()));
        size = NameRepository.getSize();
        System.out.println("Size of names after clearing: " + size);
    }
}
