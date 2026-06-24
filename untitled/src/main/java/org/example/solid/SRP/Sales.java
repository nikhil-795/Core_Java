package org.example.solid.SRP;

import java.util.List;

public class Sales {

    //sales
    void processPayment(int totalPrice){
        System.out.println("Total amount need to  pay is "+ totalPrice);
        System.out.println("Processing payment");
        System.out.println("Payment done successfully");
        System.out.println("Update inventory");
        System.out.println("Send mail to customer");
    }

    //sales
    int calculateTotal(List<Product> products){
        return products.stream()
                .mapToInt(Product::getPrice)
                .sum();
    }
}
