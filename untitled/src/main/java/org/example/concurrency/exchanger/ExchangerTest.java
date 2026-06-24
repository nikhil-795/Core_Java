package org.example.concurrency.exchanger;


import java.util.concurrent.Exchanger;

public class ExchangerTest {
    public static void main(String...e1){
        Exchanger<String> exchanger = new Exchanger<>();

        Thread t1 = new Thread(() -> {
            try {
                String msg = "Hello from T1";
                System.out.println("T1 sends: " + msg);
                String reply = exchanger.exchange(msg);
                System.out.println("T1 got: " + reply);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                String msg = "Hello from T2";
                System.out.println("T2 sends: " + msg);
                String reply = exchanger.exchange(msg);
                System.out.println("T2 got: " + reply);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
