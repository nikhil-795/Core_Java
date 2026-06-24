package org.example.collectionframework;


import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Car2 implements Comparable<Car2>{
    int price;
    String model;

    public Car2(int price, String model) {
        this.price = price;
        this.model = model;
    }

    public Car2(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car2 car = (Car2) o;
        return price == car.price;
    }

    public Car2(String model) {
        this.model = model;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public int compareTo(Car2 o) {
        return this.price - o.price;
    }
}

public class Mutation_Problem_with_Treebase_collections {

    public static void main(String...e){
        Set<Car2> set = new TreeSet<>();

        Car2 c1 = new Car2(100,"XUV");
        set.add(c1);

        Car2 c2  = new Car2(90,"XUV-Advance");
        set.add(c2);

        Car2 c3  = new Car2(200,"XUV-Advance");
        set.add(c3);

        System.out.println(set);

        c2.price = 900;

        System.out.println(set);

        System.out.println(set.contains(new Car2(900,"XUV")));
    }
}
