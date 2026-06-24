package org.Revision.Collections;

import java.util.*;

public class TreeSetPractice {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

        // Adding elements
        set.add(10);
        set.add(30);
        set.add(20);
        set.add(50);
        set.add(40);

        System.out.println("TreeSet: " + set);  // Sorted automatically

        // Remove an element
        set.remove(30);
        System.out.println("After removing 30: " + set);

        // First and last elements
        System.out.println("First element: " + set.first());
        System.out.println("Last element: " + set.last());

        // Higher and Lower
        System.out.println("Higher than 25: " + set.higher(25));
        System.out.println("Lower than 25: " + set.lower(25));

        // Subset example
        System.out.println("SubSet (10 to 40): " + set.subSet(10, 40));
    }
}

