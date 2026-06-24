package org.example.solid.OCP;

//OCP
public class PaymentProcessor_OCP {
    private PaymentProcessor paymentProcessor;

    PaymentProcessor_OCP(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }

    public void payment(int amount){
        this.paymentProcessor.processor(amount);
    }
}
