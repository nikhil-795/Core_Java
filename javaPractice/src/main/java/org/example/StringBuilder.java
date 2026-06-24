package org.example;

public class StringBuilder {
    public static void main(String[] args) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");

        String result = sb.toString();

        // Print the result
        System.out.println(result); // Output: Hello World
    }
}
