package org.example.threading;


class Buffer1 {
    private int counter;

    int getCounter(){
        return this.counter;
    }

     void increaseCounter(){
        System.out.println("entered thread "+Thread.currentThread());
        this.counter++;
        System.out.println("exited thread "+Thread.currentThread());
    }
}


class Task14 implements Runnable{

    private Buffer1 buffer;
    Task14(Buffer1 buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("current thread is started "+Thread.currentThread());
        for (int i=1;i<=5;i++){
            synchronized (this.buffer){
                System.out.println(Thread.currentThread()+" is sleeping...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread()+" is awaking......");
                this.buffer.increaseCounter();
            }
        }
        System.out.println("current thread is end "+Thread.currentThread());
    }
}

class Task13 implements Runnable{

    private Buffer1 buffer;
    Task13(Buffer1 buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("current thread is "+Thread.currentThread());
        for (int i=1;i<=5;i++){
            System.out.println(Thread.currentThread()+" waiting for lock....");
            synchronized (this.buffer){
                System.out.println(Thread.currentThread()+" got the lock....");
                this.buffer.increaseCounter();
            }
        }
        System.out.println("current thread is end "+Thread.currentThread());
    }
}

public class ThreadInterruption_With_Synchronized {
    public static void main(String... e) throws InterruptedException {
        Buffer1 buffer = new Buffer1();

        Thread t1 = new Thread(new Task14(buffer));
        t1.setName("TASK14");
        t1.setPriority(10);
        t1.start();

        Thread t2 = new Thread(new Task13(buffer));
        t2.setName("TASK13");
        t2.setPriority(1);
         try {
             t2.start();
             Thread.sleep(2000);
         } catch (InterruptedException ex) {
             throw new RuntimeException(ex);
         }

        t2.interrupt();
        System.out.println("interruption has been invoked...");
        t1.join();
        t2.join();
        System.out.println("total counter value of buffer "+buffer.getCounter());
    }
}
