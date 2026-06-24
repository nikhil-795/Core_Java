package org.example;

import java.util.ArrayList;

class A{
    static String s1 = "Tech Java";
}

public class StringEx {

    static String s2 = "Tech"+" Java";
    public static void main(String... p){
        String s3 = new String("Tech Java");
        String s4 = "Tech"+ new String(" Java");

        System.out.println(A.s1 == s2); // T
        System.out.println(s2 == s3); // f
        System.out.println(s3 == s4); // f
        System.out.println(A.s1.equals(s4)); // t

        String newString = A.s1.concat(s2);

        System.out.println(A.s1);
        System.out.println(s2);
        System.out.println(newString);

    }
}
