package org.example;

//static
public class Emp {

    String name;
    private int id;
    public static int age;
    public String dept;

    protected String address="Nikhil Home Address";

    public String getAddress() {
        return address;
    }

    public Emp(){
        System.out.println("default constructor...");
    }

    public Emp(String name, int id) {
        this.name = name;
        this.id = id;
        System.out.println("Emp(String name, int id) constructor...");
    }

    public static void show(){
        System.out.println("static show() method...");
        //System.out.println(name);
    }

    static {
        System.out.println("emp is loaded...");
        age = 30;
        show();
    }

    public void display(){
        System.out.println("display() method...");
        System.out.println(name);
        System.out.println(age);
    }
}
