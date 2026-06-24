package org.example.threading.Threading_Practice;

class Task1 implements Runnable{

    public static synchronized void display1(){
        System.out.println("Display1 method is called by "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static synchronized void display2(){
        System.out.println("Display2 method is called by "+Thread.currentThread().getName());
    }

    @Override
    public void run() {

    }
}
public class synchronized_bothMethod {
    public static void main(String[] args) {
        Thread t1=new Thread(()->Task1.display1(),"Thread-1");
        t1.start();


        Thread t2=new Thread(()->Task1.display2(),"Thread-2");
        t2.start();

    }
}
