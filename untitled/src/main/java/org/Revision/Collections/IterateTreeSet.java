package org.Revision.Collections;

import java.util.*;

public class IterateTreeSet {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");

        // Using for-each
        for (String fruit : set) {
            System.out.println(fruit);
        }

        // Using Iterator
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

