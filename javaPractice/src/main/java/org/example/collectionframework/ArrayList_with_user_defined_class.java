package org.example.collectionframework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person {
    int age;
    String name;
    String gender;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name+'}';
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }
}
public class ArrayList_with_user_defined_class {

    public static void main(String... e){
        List<Person> persons = new ArrayList<>();

        Person p1 = new Person("Gurupreet", "Sher ka bachha", 35);
        persons.add(p1);

        Person p2 = new Person("Nikhil", "Marwadi ka bachha", 25);
        persons.add(p2);

        Person p3 = new Person("Aman", "Airmarshal ka bachha", 27);
        persons.add(p3);

        System.out.println(persons);

        //find
        //System.out.println(persons.contains(p2));

        Person findp = new Person("Nikhil");
        System.out.println(persons.contains(findp));
        //remove

    }
}
