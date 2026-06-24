package org.example.solid.OCP;

//violate OCP
public class PaymentProcessor_Violates_OCP {

    public void paymentProcessor(int amount,String type){
        System.out.println("payment processor has been initiated");
        if("cc".equalsIgnoreCase(type)){
            System.out.println("payment of Rs."+amount+" is successfully done via "+type);
        }
        else if("dc".equalsIgnoreCase(type)){
            System.out.println("payment of Rs."+amount+" is successfully done via "+type);
        }
        else if("upi".equalsIgnoreCase(type)){
            System.out.println("payment of Rs."+amount+" is successfully done via "+type);
        }else if ("paytm".equalsIgnoreCase(type)){
            System.out.println("payment of Rs."+amount+" is successfully done via "+type);
        } else if("googlepay".equalsIgnoreCase(type)){
            System.out.println("payment of Rs."+amount+" is successfully done via "+type);
        }
    }
}
