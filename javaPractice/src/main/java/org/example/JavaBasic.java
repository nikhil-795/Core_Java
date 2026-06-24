package org.example;

public class JavaBasic {

    public static void main(String... r){
        System.out.println("invoked.. main().....");
       //System.out.println("emp age is "+Emp.age);
      // Emp.show();

      // Emp emp = new Emp();
       // System.out.println("emp name is "+emp.name);
        EmpChild empChild = new EmpChild();
        empChild.display();
        empChild.test();
    }
}
