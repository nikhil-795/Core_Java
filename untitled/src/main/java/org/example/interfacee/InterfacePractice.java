package org.example.interfacee;


interface Person{
    void talk();
    void walk();
    String name = "";
}

class Nikhil implements Person {

    @Override
    public void talk() {
        System.out.println("Nikhil is not able to talk in front of Purva");
    }

    @Override
    public void walk() {
        System.out.println("Nikhil walks every day on the beach...");
    }
}

public class InterfacePractice {

    public static void main(String... r){
        Person p = new Nikhil();
        p.talk();
        p.walk();
    }
}
