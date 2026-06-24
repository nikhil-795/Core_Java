package org.Revision.Opps.Polymorphism.Overriding;

public class Employee {
    private int jobgrade;
    Employee(int jobgrade){
        this.jobgrade=jobgrade;
    }
    public int getJobgrade() {
        return jobgrade;
    }

    public void PrintJobgrade(){
        System.out.println("Job Grade start from"+ this.jobgrade);
    }
    public static void main(String[] args) {
        System.out.println("Example of Overriding");
        Employee e=new Employee(6);
        e.PrintJobgrade();

        Nikhil n=new Nikhil(7);
        n.PrintJobgrade();
    }


}
