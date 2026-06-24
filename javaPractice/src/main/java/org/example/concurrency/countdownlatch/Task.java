package org.example.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable{

	private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;
  
    public Task(String name, int timeToStart, CountDownLatch latch){
        
    	this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
    }
  
    @Override
    public void run() {
        try {
        	System.out.println(Thread.currentThread().getName()+" is couting down ");
        	System.out.println(Thread.currentThread().getName()+" is going to sleep..");
            Thread.sleep(timeToStart);
            System.out.println(latch.getCount());
            latch.countDown(); //reduce count of CountDownLatch by 1
            System.out.println(latch.getCount());
            System.out.println(Thread.currentThread().getName()+" is awaking");
        } catch (InterruptedException ex) {
        	System.out.println(Thread.currentThread().getName()+" interrupted Exception........");
            ex.printStackTrace();
            latch.countDown();
        }

        System.out.println( name + " is Up");
    }
}
