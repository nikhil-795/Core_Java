package org.example;

//super
class EmpParent {

    int id;
    String dept;

    static {
        System.out.println("static intilizer block form emp-parent");
    }
   /* public EmpParent(){
        System.out.println("default constructor from EmpParent...");
        System.out.println("this from EmpParent "+this);
    }*/
    public EmpParent(int id, String dept){
        //super();
        this.dept= dept;
        this.id=id;
        System.out.println("EmpParent(int id, String dept) constructor from EmpParent... id "+id+" dept "+dept);
    }

    public void display(){
        System.out.println("display() method from EmpParent...");
        System.out.println("this is from display "+this);
    }

    public void print(){
        System.out.println("print() method from EmpParent...");
    }
}

//child
public class EmpChild extends EmpParent {

    String name;
    int id;

    static{
        System.out.println("static initlizer block form EmpChild");
    }

    public EmpChild(){
        this("Nikhil",1);
        System.out.println("default constructor from EmpChild...");
        System.out.println("this from EmpChild "+this);
    }

    public EmpChild(String name, int id) {
        //super();// default constructor
        super(id,name);
        this.name = name;
        this.id = id;
        System.out.println("EmpChild(String name, int id) constructor...");
    }

    public EmpChild(String name) {
        this(name,1);
        System.out.println("EmpSuper(String name) constructor from EmpChild ...");
    }

    public void display(){
        System.out.println("display() method from EmpChild...");
        System.out.println(name);
        System.out.println("this is from display "+this);
        System.out.println(this.id);
        super.display();
    }

    public void test(){
        System.out.println("test() method from EmpChild...");
        print();
    }
}
