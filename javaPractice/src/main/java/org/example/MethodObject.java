package org.example;

public class MethodObject implements  Cloneable{

    String name;

    MethodObject() {
        System.out.println("MethodObject default constructor...");
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();   // if i don't use super.clone() then it is thowing stackover flow??
    }
    public void display() {
        System.out.println(getClass() + " is loaded...");
        System.out.println(getClass().getName());
    }
   @Override
   public String toString() {
        return "Nikhil toString() method called";
    }
    // to print this toString you always should do sout of current class object.
    public static void main(String[] args) {
     MethodObject methodObject = new MethodObject();
     methodObject.name = "Nikhil";
        System.out.println("MethodObject name: " + methodObject.name);
        MethodObject clonedObject = null;
        try {
            clonedObject = (MethodObject) methodObject.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Cloned MethodObject name: " + clonedObject.name);
        System.out.println("hashCode of methodObject: " + methodObject.hashCode());
        System.out.println("hashCode of clonedObject: " + clonedObject.hashCode());

        if(methodObject == clonedObject) {
            System.out.println("Both objects are the same instance.");
        } else if (methodObject.equals(clonedObject)) {
            System.out.println("Objects are equal but different instances.");
        } else {
            System.out.println("Objects are different instances.");
        }
        // This will print the name of the class using .getName()
        methodObject.display();
        System.out.println(methodObject);
        //System.out.println("toString() output: " + methodObject + "\n");

    }
}
