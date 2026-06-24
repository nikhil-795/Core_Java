package org.example.collectionframework;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

final class Car1 {
   private int price;
    private String model;

    public Car1(int price, String model) {
        this.price = price;
        this.model = model;
    }

    public Car1(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car1 car = (Car1) o;
        return price == car.price;
    }

    public Car1(String model) {
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

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}

public class Mutation_Problem_Solved_with_hashbased_collections {

    public static void main(String...e){
        Set<Car1> set = new HashSet<>();

        Car1 c1 = new Car1(50000,"XUV");
        set.add(c1);

        Car1 c2  = new Car1(500000,"XUV-Advance");
        set.add(c2);

        System.out.println(set);

        System.out.println(set.contains(new Car(50000,"XUV")));

       // c1.price = 100000;

        System.out.println(set);

        System.out.println(set.contains(new Car(50000,"XUV")));

        System.out.println(set.contains(new Car(100000,"XUV")));
    }
}
