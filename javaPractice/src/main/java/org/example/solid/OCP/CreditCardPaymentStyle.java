package org.example.solid.OCP;

public class CreditCardPaymentStyle implements PaymentProcessor{
    @Override
    public void processor(int payment) {
        System.out.println("payment of Rs."+payment+" is successfully done via "+this.getClass().getName());
    }
}
