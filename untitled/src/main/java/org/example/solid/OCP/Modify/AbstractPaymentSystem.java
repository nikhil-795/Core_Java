package org.example.solid.OCP.Modify;

public abstract class AbstractPaymentSystem {


    public void process(int amount,String paymentMethod) {
        System.out.println("payment of Rs."+amount+" is successfully done via "+paymentMethod);
    }
}
