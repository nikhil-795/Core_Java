package org.example.solid.OCP.Modify;

public class Ocp_Nik {
        public static void main(String[] args) {

            IPaymentProcessor paytmProcessor = new PaytmPayment();
            PaymentService paymentService1 = PaymentService.getInstance();
            paymentService1.setPaymentProcessor(paytmProcessor);
            paymentService1.pay(1000);

            IPaymentProcessor creditCardProcessor =new GooglePayPayment();
            PaymentService paymentService = PaymentService.getInstance();
            paymentService.setPaymentProcessor(creditCardProcessor);
            paymentService.pay(500);
        }
    }

