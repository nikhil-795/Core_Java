package org.example.solid.SRP;

import java.util.List;
import java.util.stream.Collectors;

public class Order_With_SRP {

    private List<Product> products;

    public Order_With_SRP(List<Product> products) {
        this.products = products;
    }

    //used by inventory
    void addProducts(Product product){
        this.products.add(product);
    }
    //used by inventory
    void removeProduct(int productId){
        products = this.products.stream().filter(p -> p.getId() != productId
        ).collect(Collectors.toList());
    }

    List<Product> getProducts(){
        return this.products;
    }

}
