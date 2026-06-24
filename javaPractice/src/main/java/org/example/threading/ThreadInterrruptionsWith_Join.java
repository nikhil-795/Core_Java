package org.example.threading;

class JoinInterruption implements Runnable{

    private Thread mainThread;
    JoinInterruption(Thread mainThread){
        this.mainThread = mainThread;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("i is "+i);

            if( i == 5 ){
                System.out.println("1 isInterrupted value " +mainThread.isInterrupted());
                mainThread.interrupt();
                System.out.println("2 isInterrupted value " +mainThread.isInterrupted());
            }
        }
    }
}

public class ThreadInterrruptionsWith_Join {
    public static void main(String... e){
        Thread t = new Thread( new JoinInterruption(Thread.currentThread()));
        t.start();

        try {
            System.out.println("main threading waiting to finish its child thread..");
            t.join();
            System.out.println("child thread is over , so main thread is also end...");
        } catch (Exception ex) {
           ex.printStackTrace();
        }

    }
}
