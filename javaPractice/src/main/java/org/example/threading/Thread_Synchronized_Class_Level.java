package org.example.threading;

class Buffer11 {
    private static int counter;

    int getCounter(){
        return this.counter;
    }

    //acquire monitor of class of Type Class
    synchronized static void increaseCounter(){
        System.out.println("entered thread "+Thread.currentThread());
        counter++;
        try {
            System.out.println("static method is sleeping....");
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("exited thread "+Thread.currentThread());
    }


    //acquire monitor of instance of buffer class
    //this can be access by any-other thread
     void print(){
        System.out.println("entered thread "+Thread.currentThread());
        try {
            System.out.println("print method is sleeeping....");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       // System.out.println(Thread.currentThread()+" accessing print() method...");
    }
}

class Task111 implements Runnable{

    private Buffer11 buffer;
    Task111(Buffer11 buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        //System.out.println("current thread is started "+Thread.currentThread());
        //for (int i=1;i<=5;i++){
            //try {
                this.buffer.increaseCounter();
               // Thread.sleep(500);
            //} catch (InterruptedException e) {
               // throw new RuntimeException(e);
            //}
      // }
        System.out.println("current thread is end "+Thread.currentThread());
    }
}

class Task112 implements Runnable{

    private Buffer11 buffer;
    Task112(Buffer11 buffer){
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
        synchronized (Buffer.class){
            this.buffer.print();
        }
           // } catch (InterruptedException e) {
              //  throw new RuntimeException(e);
            //}
       // }
        System.out.println("current thread is end "+Thread.currentThread());
    }
}


class Task113 implements Runnable{

    private Buffer11 buffer;
    Task113(Buffer11 buffer){
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
        synchronized (Buffer.class){
            this.buffer.print();
        }
        // } catch (InterruptedException e) {
        //  throw new RuntimeException(e);
        //}
        // }
        System.out.println("current thread is end "+Thread.currentThread());
    }
}

public class Thread_Synchronized_Class_Level {
    public static void main(String...e) throws InterruptedException {
        Buffer11 buffer = new Buffer11();

        Thread t1 = new Thread(new Task111(buffer));
       // t1.start();

        Thread t2 = new Thread(new Task112(buffer));
        t2.start();

        Buffer11 buffer1 = new Buffer11();

        Thread t3 = new Thread(new Task113(buffer1));
        t3.start();

       // t1.join();
       // t2.join();
    }
}
