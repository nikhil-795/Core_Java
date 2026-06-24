package org.example.solid.OCP.Modify;

public class PaymentService {

    private static PaymentService instance;
    private  IPaymentProcessor paymentProcessor;

    private PaymentService() {
    }

    public static PaymentService getInstance() {
        if(instance== null){
           instance= new PaymentService();
        }
        return instance;
    }

    public void setPaymentProcessor(IPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void pay(int amount) {
        paymentProcessor.process(amount);
    }
}

