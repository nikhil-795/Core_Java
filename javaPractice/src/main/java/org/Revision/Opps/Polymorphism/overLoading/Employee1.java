package org.Revision.Opps.Polymorphism.overLoading;

public class Employee1 {
    private int id;
    private String name;
    private String dept;

    Employee1(int id, String name){
        this.id=id;
        this.name=name;
    }

    public void show(int id){
        System.out.println("Employee id is "+ id);
    }

    public void show(String name){
        System.out.println("Employee name is "+ name);
    }

    public void show(int id, String name){
        System.out.println("Employee id is "+ id + " and name is "+ name);
    }
    public void show(String name, int id){
        System.out.println("Employee name is "+ name + " and id is "+ id);
    }


    public static void main(String[] args) {
        System.out.println("Example of Overloading");
        Employee1 e1=new Employee1(101,"Nikhil");
        e1.show(101);
        e1.show("Nikhil");
        e1.show(101,"Nikhil");
        e1.show("Nikhil",101);
        System.out.println("------------------");

        Employee1 e2= new Employee1(102,"Amit");
        e2.show(102);
        e2.show("Amit");
        e2.show(102,"Amit");
        e2.show("Amit",102);
    }
}
