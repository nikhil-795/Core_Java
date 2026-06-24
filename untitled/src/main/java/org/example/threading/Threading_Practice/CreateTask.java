package org.example.threading.Threading_Practice;

class Task implements Runnable{

    @Override
    public void run(){
        System.out.println("Thread is  "+Thread.currentThread());

    }
}

public class CreateTask {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
        t1.setName("Thread-1");
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread t2 = new Thread(new Task());
        t2.setName("Thread-2");
        t2.start();
    }
}
