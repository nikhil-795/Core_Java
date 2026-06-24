package org.example.immutable;

//mutable
final class EmpMutable{

    private String name;

    EmpMutable(String name){
        this.name = name;
    }
    void setter(String name){
        this.name = name;
    }
    String getter(){
        return this.name;
    }

}

//immutable
final class MyImmutableClass{

    private final String name;
    private final EmpMutable instance;

    public MyImmutableClass(String name, EmpMutable instance){
        this.name = name;
        this.instance = new EmpMutable(instance.getter()); // defensive copy
    }
    public String getName(){
        return this.name;
    }
    public EmpMutable getEmp(){
        return new EmpMutable(this.instance.getter()); // defensive copy
    }
}

public class Immutable {
    public static void main(String... r){

        EmpMutable empMutable = new EmpMutable("nkkhil");
        System.out.println(empMutable.getter());

        MyImmutableClass obj = new MyImmutableClass("abc",empMutable);
        System.out.println(obj.getName());
        System.out.println(obj.getEmp().getter());

        empMutable = obj.getEmp();
        empMutable.setter("xyz");

        System.out.println(obj.getEmp().getter());

        System.out.println(empMutable.getter());
    }
}
