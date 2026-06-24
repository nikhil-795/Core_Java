package org.example.threading.Threading_Practice;

public class CreateThread {

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread is running"+Thread.currentThread());
        }
    }
    public static void main(String[] args) {
     MyThread t1=new MyThread();
     t1.setName("Thread-1");
     MyThread t2=new MyThread();
     t2.setName("Thread-2");

        t1.start();
        t2.start();


        t1.start();
    }
}
