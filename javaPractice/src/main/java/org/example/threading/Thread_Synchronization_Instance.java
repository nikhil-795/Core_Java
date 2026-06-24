package org.example.threading;

class Buffer {
    private int counter;

    int getCounter(){
        return this.counter;
    }

    synchronized void increaseCounter(){
        System.out.println("entered thread "+Thread.currentThread());
        this.counter++;
        System.out.println("exited thread "+Thread.currentThread());
        //print();
    }


    //this can be access by any-other thread
    synchronized void print(){
        System.out.println(Thread.currentThread()+" accessing print() method...");
    }
}

class Task11 implements Runnable{

    private Buffer buffer;
    Task11(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("current thread is started "+Thread.currentThread());
        for (int i=1;i<=10;i++){
            try {
                    this.buffer.increaseCounter();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("current thread is end "+Thread.currentThread());
    }
}

class Task12 implements Runnable{

    private Buffer buffer;
    Task12(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("current thread is "+Thread.currentThread());
        for (int i=1;i<=10;i++){
            try {
                    System.out.println(Thread.currentThread()+" is sleeping...");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread()+" is awaking......");
                    this.buffer.increaseCounter();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("current thread is end "+Thread.currentThread());
    }
}

public class Thread_Synchronization_Instance {

    public static void main(String... e) throws InterruptedException {

        Buffer buffer = new Buffer();

        Thread t1 = new Thread(new Task11(buffer));
        t1.start();

        Thread t2 = new Thread(new Task12(buffer));
        t2.start();

        t1.join();
        t2.join();
        System.out.println("total counter value of buffer "+buffer.getCounter());
    }
}
