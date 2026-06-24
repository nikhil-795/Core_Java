package org.example.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable{
	
	private final CyclicBarrier cyclicBarrier;
	    public Task(CyclicBarrier cyclicBarrier) {
	        this.cyclicBarrier = cyclicBarrier;
	    }

	    @Override
	    public void run() {
	        System.out.println("Starting service...");
	       /* try {
	            Thread.sleep(1000);

	        } catch (InterruptedException e1) {
	        	System.out.println("service one interupted...(InterruptedException)...");
	            e1.printStackTrace();

	        }*/

	       // System.out.println("Service One has finished its work... waiting for others...");

	        try {
	        	System.out.println("calling......... service await() method...");
	            cyclicBarrier.await();
	            System.out.println("called service  await()... method finished.......");

	        } catch (InterruptedException e) {
	            System.out.println(Thread.currentThread().getName()+" interrupted! (InterruptedException using await()).............");
	            e.printStackTrace();
	        } catch (BrokenBarrierException e) {
	            System.out.println(Thread.currentThread().getName()+" interrupted! - BrokenBarrierException");
	            e.printStackTrace();
	        }
	        System.out.println("The wait is over, lets complete Service!");
	    }
}
