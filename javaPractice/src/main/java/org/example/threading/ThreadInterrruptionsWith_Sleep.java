package org.example.threading;

class SleepInterruption implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("i is "+i);
            Thread t1 = Thread.currentThread();
                try {
                    System.out.println("1 isInterrupted value " +t1.isInterrupted());
                    System.out.println("Thread is going to sleep........");
                    Thread.sleep(10000);
                    System.out.println("Thread is awaken........");
                    System.out.println("2 isInterrupted value " +t1.isInterrupted());
                } catch (Exception e) {
                    throw new RuntimeException("exception ocurred while interrupting thread. and thread is ending....");
                }
        }
    }
}

public class ThreadInterrruptionsWith_Sleep {
    public static void main(String... e){
        Thread t = new Thread( new SleepInterruption());
        t.start();

        try {
            System.out.println("main threading interrupting child thread..");
            //Thread.sleep(1000);
            t.interrupt();
        } catch (Exception ex) {
            System.out.println("main thread interrupted....");
        }

    }
}
