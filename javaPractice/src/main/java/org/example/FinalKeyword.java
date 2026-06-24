package org.example;

//final

class SuperClass{

    final String name;
    int k=10;
    SuperClass(){
        this.name="dfd";
    }


   final void test(){
        System.out.println("test from superclass");
        final int i=10;
       System.out.println(i);
    }

    void print(){
        System.out.println("print method from superclass");
    }
}

class childClass extends SuperClass{

    /*void test(){
        System.out.println("test from superclass");
    }*/ // can't inherit
}

public class FinalKeyword {

    public static void main(String... r){
        final SuperClass obj = new childClass();

        obj.test();

      //  obj.name = "dfdf";
        System.out.println(obj.name);
        System.out.println(obj.k);
        obj.k = 100;
        System.out.println(obj.k);


    }
}
