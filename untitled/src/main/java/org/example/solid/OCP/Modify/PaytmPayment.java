package org.example.solid.OCP.Modify;

public class PaytmPayment extends AbstractPaymentSystem implements IPaymentProcessor {
    @Override
    public void process(int amount) {
        System.out.println("Paytm payment processing...");
        this.process(amount,this.getClass().getName());
    }
}
