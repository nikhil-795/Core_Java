package org.example.threading;

class DaemonDemo{

    void runDaemon(Runnable task, boolean isDaemon){
        Thread t = new Thread(task);
        t.setDaemon(isDaemon);
        t.start();
    }
}

class Job implements Runnable{

    @Override
    public void run() {
            while(true){
                try{
                    System.out.println("Daemon thread is sleeping....");
                    Thread.sleep(10000);
                    System.out.println("Daemon thread is awakinig.....");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
    }
}
public class DaemonThread {

    public static void main(String... e){
        DaemonDemo d = new DaemonDemo();
        d.runDaemon(new Job(), true);

        try {
            System.out.println("main thread is sleeping...");
            Thread.sleep(3000);
            System.out.println("main thread is awaking...");
        }catch (InterruptedException ee){
            ee.printStackTrace();
        }
    }
}
