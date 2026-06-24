package org.example.collectionframework;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Car {
    int price;
    String model;

    public Car(int price, String model) {
        this.price = price;
        this.model = model;
    }

    public Car(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price;
    }

    public Car(String model) {
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
}
public class Mutation_Problem_with_HashingBasedCollections {
    public static void main(String...e){
        Set<Car> set = new HashSet<>();

        Car c1 = new Car(50000,"XUV");
        set.add(c1);

        Car c2  = new Car(500000,"XUV-Advance");
        set.add(c2);

        System.out.println(set);

        System.out.println(set.contains(new Car(50000,"XUV")));

        c1.price = 100000;

        System.out.println(set);

        System.out.println(set.contains(new Car(50000,"XUV")));

        System.out.println(set.contains(new Car(100000,"XUV")));
    }
}
