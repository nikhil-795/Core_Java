package org.example.solid.SRP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SRP {
    public static void main(String... r){

        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Gaming Laptop", 75000, 1, "Laptop"),
                new Product("Android Smartphone", 25000, 2, "Phone"),
                new Product("Wireless Bluetooth", 5000, 3, "Headphones"),
                new Product("Mechanical Keyboard", 7000, 4, "Keyboard")
        ));
        Order_With_SRP obj = new Order_With_SRP(products);
        obj.addProducts(new Product("Gaming Laptop 1", 75000, 5, "Laptop-X"));

        Finance fin = new Finance();
        fin.generateInvoice(obj.getProducts());

        Sales sales = new Sales();
        int totalPrice = sales.calculateTotal(obj.getProducts());
        System.out.println(totalPrice);
        sales.processPayment(totalPrice);
    }
}
