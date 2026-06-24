package org.example.solid.SRP;

import java.util.List;
import java.util.stream.Collectors;

//violates SRP
public class Order_Violates_SRP {

    private List<Product> products;

    //used by inventory
    void addProducts(Product product){
        this.products.add(product);
    }
    //used by inventory
    void removeProduct(int productId){
        products = this.products.stream().filter(p -> p.getId() != productId
        ).collect(Collectors.toList());
    }

    //sales
    void processPayment(int totalPrice){
        System.out.println("Total amount need to  pay is "+ totalPrice);
        System.out.println("Processing payment");
        System.out.println("Payment done successfully");
        System.out.println("Update inventory");
        System.out.println("Send mail to customer");
    }

    //finance
    void generateInvoice(){
        System.out.println(this.products);
    }

    //sales
    int calculateTotal(){
        return this.products.stream()
                .mapToInt(Product::getPrice)
                .sum();
    }
}
