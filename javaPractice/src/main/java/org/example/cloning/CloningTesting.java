package org.example.cloning;

class Nikhil{
    private String type;

    public Nikhil(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
class Person implements Cloneable{
    private int age;
    private String name;
    private Nikhil nikhil;

    public Person(int age, String name,Nikhil nikhil) {
        this.age = age;
        this.name = name;
        this.nikhil = nikhil;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", nikhil=" + nikhil +
                '}';
    }

    public Nikhil getNikhil() {
        return nikhil;
    }

    @Override
    public Person clone() throws CloneNotSupportedException{
        return (Person)super.clone();
    }
}
public class CloningTesting {

    public static void main(String ...e) throws CloneNotSupportedException {
        Person p = new Person(100,"Nikhil", new Nikhil("Homo-Spiyapins"));
        System.out.println(p);
        System.out.println("p "+p.hashCode());

        System.out.println(p.getNikhil());
        System.out.println(p.getNikhil().hashCode());

        Person p1 =  p.clone();
        System.out.println(p1);
        System.out.println("p1 " +p1.hashCode());
        System.out.println(p1.getNikhil());
        System.out.println(p1.getNikhil().hashCode());

        p1.getNikhil().setType("Nikhil is Chimpaing");

        System.out.println(p1.getNikhil().getType());

        System.out.println(p.getNikhil().getType());
    }
}
