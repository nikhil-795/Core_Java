package org.Revision.Opps.Polymorphism.Overriding;

public class Nikhil extends Employee {

    Nikhil(int jobgrade) {
        super(jobgrade);
    }

    @Override
    public void PrintJobgrade(){
        System.out.println("Job Grade of Nikhil "+ this.getJobgrade());
    }
}
