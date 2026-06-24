package org.example.collectionframework;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Employee {
    int age;
    int salary;
    String name;
    String dept;

    public Employee(int age, String dept, String name, int salary) {
        this.age = age;
        this.dept = dept;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}

class AgeSorting implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.age, o2.age);
    }
}

class SalarySorting implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.salary, o2.salary);
    }
}
public class TreeMap_With_user_defined_object1 {

    public static void main(String ...e){
        Employee e1 = new Employee(30,"IT","Nikhil",2000000);
        Employee e2 = new Employee(40,"Devops","kasturi",50000);
        Employee e3 = new Employee(27,"patisa","Aman",1000000);
        Employee e4 = new Employee(50,"IT","Suresh",10000000);

        Map<Employee, String> map = new TreeMap<>(new AgeSorting());

        map.put(e1,"IN");
        map.put(e2,"IN");
        map.put(e3,"IN");
        map.put(e4,"IN");

        System.out.println(map);

        Map<Employee, String> map1 = new TreeMap<>(new SalarySorting());
        map1.putAll(map);

        System.out.println(map1);
    }
}
