package org.example;


class PackageClass extends Emp{

}

public class PExampleSubClass {

    public static void main(String... r) {
        PackageClass o = new PackageClass();
        System.out.println(o.dept);
        System.out.println(o.name);
        System.out.println(o.age);
       // System.out.println(o.id);
    }
}
