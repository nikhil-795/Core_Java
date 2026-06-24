package org.example.threading;


//it is a task/job not a thread
class Task1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i from Thread " + Thread.currentThread() + " " + i);
            if(i==5){
                try {
                    System.out.println(Thread.currentThread()+" going to sleep");
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread()+" is awaken");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

//it is a task/job not a thread
class Task2 implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("j from Thread "+Thread.currentThread()+" "+i);
            if(i==5){
                try {
                    System.out.println(Thread.currentThread()+" going to sleep");
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread()+" is awaken");
                    System.out.println("isDaemon "+Thread.currentThread().isDaemon());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ThreadTask {
    public static void main(String...e) throws InterruptedException {
        Thread t1 = new Thread(new Task1());
        t1.setName("Task1");
       // t1.setPriority(1);
        t1.start();
        
        System.out.println("1 current thread from main() method " +Thread.currentThread());
        Thread t2 = new Thread(new Task2());
        t2.setName("Task2");
        t2.setDaemon(true);
       // t2.setPriority(10);

        t2.start();

        System.out.println("2 current thread from main() method " +Thread.currentThread());

        t1.join();
        t2.join();
        System.out.println("ending main thread..........");
    }
}
