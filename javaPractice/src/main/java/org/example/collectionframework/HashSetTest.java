package org.example.collectionframework;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String ... e){
        Set<String> set = new HashSet<>();
        System.out.println(set.add("1"));
        System.out.println(set.add("2"));
        System.out.println(set.add("2"));

    }
}
