package org.example;

//overload and overriding...

class Overloading {
    void sum(int a, int b){
        System.out.println(a+b);
    }

    int sum(float a, int b){
        System.out.println(a+b);
        return (int) (a+b);
    }
    float sum(int a, float b){
        System.out.println(a+b);
        return  (a+b);
    }
}


class OverridingParent{

    int age=10;
    void display(){
        System.out.println("display from Parent");
    }

    int show(int a,String abc) {
        System.out.println("display show from parent ");
        return 0;
    }

    static void print(){
        System.out.println("print from parent");
    }

}

class OverridingChild extends OverridingParent {

   int age=100;
    void display(){
        System.out.println("display from child "+super.age);
    }
    int show(String abc,int a){
        System.out.println("show from child");
        return 0;
    }

    static void print(){
        System.out.println("print from child");
    }

}


class ParentOverriding_With_Diff{

     private void show(){}

    public OverridingParent display(){
        System.out.println("from object");
         return null;
    }

    void print()   {}
}

class ChildOverriding_With_Diff extends ParentOverriding_With_Diff{
    public void  show(){}

    public OverridingChild  display(){
        System.out.println("from String");
        return null;
    }

    void print() throws RuntimeException {}
}

public class Inheritance {

    public static void main(String[] t){
        Overloading obj = new Overloading();
        obj.sum(12,13);
        obj.sum(13f,45);

       OverridingChild child = new OverridingChild();
       OverridingParent parent = new OverridingChild();
        OverridingParent parent1 = new OverridingParent(); //
       // OverridingChild child1 = new OverridingParent(); // error

        System.out.println(parent.age);
        parent1.show(1,"3");
        parent1.print();//error
       // parent1.

        child.display();
        child.show(1,"3");
        child.print();
       // child.print()
       // child.

       // parent.display();
        parent.show(1,"3");

        parent.print(); //error

        ParentOverriding_With_Diff dd = new ChildOverriding_With_Diff();
        dd.display();
    }
}
