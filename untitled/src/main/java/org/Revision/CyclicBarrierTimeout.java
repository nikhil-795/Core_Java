package org.Revision;

import java.util.concurrent.*;

public class CyclicBarrierTimeout {
    public static void main(String[] args) {
        // Barrier for 2 threads
         CyclicBarrier barrier = new CyclicBarrier(2);

        // First thread (will timeout)
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("Thread 1 waiting...");
                    barrier.await(2, TimeUnit.SECONDS);  // only waits 2 sec
                    System.out.println("Thread 1 crossed barrier!");
                } catch (TimeoutException e) {
                    System.out.println("Thread 1 got TimeoutException!");
                } catch (BrokenBarrierException e) {
                    System.out.println("Thread 1 got BrokenBarrierException!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Second thread (comes late)
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(4000); // delay
                    System.out.println("Thread 2 waiting...");
                    barrier.await(2, TimeUnit.SECONDS);
                    System.out.println("Thread 2 crossed barrier!");
                } catch (TimeoutException e) {
                    System.out.println("Thread 2 got TimeoutException!");
                } catch (BrokenBarrierException e) {
                    System.out.println("Thread 2 got BrokenBarrierException!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
