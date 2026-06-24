package org.example;

interface TestInterface{
    void remote();
}

class BindingParent{

   private void show(){
        System.out.println("show");
    }

    void display(){
        System.out.println("");
        show();
    }
    static void print(){
        System.out.println("print..");
    }
}

class BindingChild extends BindingParent implements TestInterface  {

    void display(){
        System.out.println("");
        super.display();
    }

    @Override
    public void remote() {
        System.out.println("rmeovte");
    }
}

public class Binding {

    public static void main(String[] t){

        BindingParent obj = new BindingParent();
        obj.display();
        new BindingChild().remote();
        BindingParent.print();
    }
}
