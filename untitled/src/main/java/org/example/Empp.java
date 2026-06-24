package org.example;

//this
public class Empp {

     String name;
     int id;

    public Empp(){
        this("Nikhil",1);
        System.out.println("default constructor...");
        System.out.println("this "+this);
    }

    public Empp(String name, int id) {
        this.name = name;
        this.id = id;
        System.out.println("Empp(String name, int id) constructor...");
    }

    public Empp(String name) {
        this(name,1);
       // this.name = name;
        System.out.println("Empp(String name) constructor...");
    }

    public Empp(int id) {
       // this.id = id;
        this("abc",id);
        System.out.println("Empp(int id) constructor...");
    }


    public Empp display(){
        System.out.println("display() method...");
        System.out.println(name);
        System.out.println("this is from display "+this);
        System.out.println(this.id);
        return this;
    }

    public Empp show(){
        System.out.println("show() method...");
        return this;
    }

    public void test(){
        System.out.println("test() show...");
    }
}
