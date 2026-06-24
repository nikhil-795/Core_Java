package org.example;


import java.io.IOException;
import java.util.StringJoiner;

public class StringBuffer {
    public static void main(String... r) throws IOException {
        java.lang.StringBuffer sb = new java.lang.StringBuffer("GURU");
        System.out.println(sb);
        sb.append(" abc,");
        sb.append(" pqr,");
        sb.append(" xyz");
        System.out.println(sb);
       // sb.reverse();
        System.out.println(sb);
        sb.toString();
        //StringBuffer str="dfdfdf"; // error

        // DIY -> StringBuilder

        StringJoiner sj = new StringJoiner(",");
        sj.add("abc").add("pqr").add("xyz");
        System.out.println(sj.toString());

        System.out.println(System.currentTimeMillis());
        char[] ch = sb.toString().toCharArray();

        char[] des = new char[10];
        System.arraycopy(ch,4,des,5,5);
        System.out.println(des);
    }
}
