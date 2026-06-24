package org.example.solid.OCP;

public class OCP {

    public static void main(String... r){
       /* new PaymentProcessor_Violates_OCP().paymentProcessor(1000,"cc");
        new PaymentProcessor_Violates_OCP().paymentProcessor(1000,"dc");
        new PaymentProcessor_Violates_OCP().paymentProcessor(1000,"paytm");*/

        CreditCardPaymentStyle cc = new CreditCardPaymentStyle();
        PaymentProcessor_OCP paymentProcessorOcp = new PaymentProcessor_OCP(cc);
        paymentProcessorOcp.payment(1000);

        PaytmPaymentStyle paytmPaymentStyle = new PaytmPaymentStyle();
         paymentProcessorOcp = new PaymentProcessor_OCP(paytmPaymentStyle);
        paymentProcessorOcp.payment(1100);

        GooglePayPaymentStyle googlePayPaymentStyle = new GooglePayPaymentStyle();
        paymentProcessorOcp = new PaymentProcessor_OCP(googlePayPaymentStyle);
        paymentProcessorOcp.payment(20000);

        System.out.println(cc.hashCode());
        System.out.println(paytmPaymentStyle.hashCode());

        System.out.println(cc.getClass().getName());
        System.out.println(cc.getClass().getTypeName());
        System.out.println(cc.getClass().getPackageName());

    }
}
