package org.example.solid.OCP.Modify;

public class GooglePayPayment extends AbstractPaymentSystem implements IPaymentProcessor{

    @Override
    public void process(int amount) {
        System.out.println("Google Pay payment processing...");
        this.process(amount,this.getClass().getName());
    }
}

