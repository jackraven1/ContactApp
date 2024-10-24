package se.lexicon;

import java.util.Arrays;

public class NameRepository {
    private static String[] names = new String[0];

    // Returns the number of names in the repository
    public static int getSize() {
        return names.length;
    }

    // Sets the names array to a new array of names
    public static void setNames(String[] names) {
        NameRepository.names = Arrays.copyOf(names, names.length);
    }

    // Clears all names from the repository
    public static void clear() {
        names = new String[0];
    }

    // Returns all names in the repository as an array
    public static String[] findAll() {
        return Arrays.copyOf(names, names.length);
    }

    // Finds and returns a specific name if it exists in the repository
    public static String find(final String fullName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(fullName)) {
                return names[i]; // Return the found name
            }
        }
        return null; // Return null if the name is not found
    }

    // Adds a new name to the repository if it doesn't already exist
    public static boolean add(final String fullName) {
        if (find(fullName) == null) { // Check if the name already exists
            names = Arrays.copyOf(names, names.length + 1); // Resize the array
            names[names.length - 1] = fullName; // Add the new name to the end of the array
            return true; // Return true if the name was added successfully
        }
        return false; // Return false if the name already exists
    }

    // Finds and returns all names that match the given first name
    public static String[] findByFirstName(final String firstName) {
        String[] allFullNamesArray = findAll(); // Get all names
        String[] allMatches = new String[0]; // Initialize an empty array for matches
        for (String name : allFullNamesArray) { // Iterate through all names
            String[] tempFullName = name.split(" "); // Split the name into first and last
            if (tempFullName[0].equals(firstName)) { // Check if the first name matches
                allMatches = Arrays.copyOf(allMatches, allMatches.length + 1); // Resize the matches array
                allMatches[allMatches.length - 1] = name; // Add the matching name to the array
            }
        }
        return allMatches; // Return all matching names
    }

    // Finds and returns all names that match the given last name
    public static String[] findByLastName(final String lastName) {
        String[] allFullNamesArray = findAll(); // Get all names
        String[] allMatches = new String[0]; // Initialize an empty array for matches
        for (String name : allFullNamesArray) { // Iterate through all names
            String[] tempFullName = name.split(" "); // Split the name into first and last
            if (tempFullName[1].equals(lastName)) { // Check if the last name matches
                allMatches = Arrays.copyOf(allMatches, allMatches.length + 1); // Resize the matches array
                allMatches[allMatches.length - 1] = name; // Add the matching name to the array
            }
        }
        return allMatches; // Return all matching names
    }

    // Updates an existing name with a new name if the new name doesn't already exist
    public static boolean update(final String original, final String updatedName) {
        if (find(updatedName) != null) { // Check if the updated name already exists
            return false; // Return false if the updated name exists
        }
        for (int i = 0; i < names.length; i++) { // Iterate through names
            if (names[i].equals(original)) { // Check if the original name matches
                names[i] = updatedName; // Update the name
                return true; // Return true if the name was updated successfully
            }
        }
        return false; // Return false if the original name was not found
    }

    // Removes a name from the repository if it exists
    public static boolean remove(final String fullName) {
        int indexToRemove = -1; // Initialize the index to -1
        for (int i = 0; i < names.length; i++) { // Iterate through names
            if (names[i].equals(fullName)) { // Check if the full name matches
                indexToRemove = i; // Store the index of the name to remove
                break; // Exit the loop once found
            }
        }
        if (indexToRemove == -1) { // If the name wasn't found
            return false; // Return false
        }

        String[] tempArr = new String[names.length - 1]; // Create a temporary array with one less slot
        for (int i = 0, j = 0; i < names.length; i++) { // Iterate through names
            if (i != indexToRemove) { // Skip the index to remove
                tempArr[j++] = names[i]; // Copy other elements
            }
        }
        names = tempArr; // Update the original array
        return true; // Return true if the name was removed successfully
    }
}
