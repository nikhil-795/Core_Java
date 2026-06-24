package org.Revision.Collections;

import java.util.*;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        // Create LinkedHashSet
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // Add elements
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java"); // Duplicate - won’t be added
        set.add(null);   // Allowed

        // Print LinkedHashSet
        System.out.println("LinkedHashSet: " + set);

        // Remove element
        set.remove("C++");

        // Check if element exists
        System.out.println("Contains Python? " + set.contains("Python"));

        // Iterate using for-each
        for (String s : set) {
            System.out.println(s);
        }
    }
}

