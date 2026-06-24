package org.example.threading;


class Buffer114 {
    private static int counter;

    private final Object readLock = new Object();
    private final Object writeLock = new Object();

    int getCounter(){
        return this.counter;
    }

    //acquire monitor of class of Type Class
    //t1
      void increaseCounterWrite(){
        synchronized (this.writeLock){
        System.out.println("entered thread "+Thread.currentThread());
        counter++;
        try {
            System.out.println("static method is sleeping....");
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }
        //System.out.println("exited thread "+Thread.currentThread());
    }


    //acquire monitor of instance of buffer class
    //this can be access by any-other thread
    //only t2
     void printRead() {
         synchronized (this.readLock) {
             System.out.println("entered thread " + Thread.currentThread());
             try {
                 System.out.println("print method is sleeping....");
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             // System.out.println(Thread.currentThread()+" accessing print() method...");
         }
     }
}

class Task1110 implements Runnable{

    private Buffer114 buffer;
    Task1110(Buffer114 buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        //System.out.println("current thread is started "+Thread.currentThread());
        //for (int i=1;i<=5;i++){
        //try {
        this.buffer.increaseCounterWrite();
        // Thread.sleep(500);
        //} catch (InterruptedException e) {
        // throw new RuntimeException(e);
        //}
        // }
        System.out.println("current thread is end "+Thread.currentThread());
    }
}

class Task115 implements Runnable{

    private Buffer114 buffer;
    Task115(Buffer114 buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        // System.out.println("current thread is "+Thread.currentThread());
        //for (int i=1;i<=5;i++){
        //try {
        // System.out.println(Thread.currentThread()+" is sleeping...");
        // Thread.sleep(1000);
        // System.out.println(Thread.currentThread()+" is awaking......");

            this.buffer.printRead();

        // } catch (InterruptedException e) {
        //  throw new RuntimeException(e);
        //}
        // }
        System.out.println("current thread is end "+Thread.currentThread());
    }
}

public class Thread_Synchronized_On_Object {

    public static void main(String...e) throws InterruptedException {
        Buffer114 buffer = new Buffer114();

        Thread t1 = new Thread(new Task1110(buffer));
        t1.start();

        Thread t2 = new Thread(new Task115(buffer));
        t2.start();
        // t1.join();
        // t2.join();
    }
}
