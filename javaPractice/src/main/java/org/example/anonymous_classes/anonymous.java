package org.example.anonymous_classes;

abstract class Plane{

    void show(){
        System.out.println("it is show()");
    }
    abstract void display();
}

interface Book{
    void show();
}

public class anonymous {
    public static void main(String... e){
        Plane p = new Plane(){

            @Override
            void display() {
                System.out.println("it is display");
            }
            @Override
            void show(){
                System.out.println("it is show from anonymous class........");
            }
        };

        p.show();
        p.display();

        Book b = new Book(){
            @Override
            public void show() {
                System.out.println("it is show from book interface....");
            }
        };
        b.show();
    }
}
