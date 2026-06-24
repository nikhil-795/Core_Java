package org.AccessModifier;

import org.example.Emp;


public class AccessModifierytest extends Emp{
    public static void main(String... r) {
        System.out.println("Access Modifier Test");

        Emp emp = new Emp();
        String dept = emp.dept;
        System.out.println("emp dept is " + dept);

        int age = emp.age;
        System.out.println("emp age is " + age);

        String address = emp.getAddress();
        System.out.println("emp address is " + address);


    }
}
