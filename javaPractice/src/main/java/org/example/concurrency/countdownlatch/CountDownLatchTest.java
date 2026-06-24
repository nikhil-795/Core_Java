package org.example.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String args[]) {
		
	       final CountDownLatch latch = new CountDownLatch(0);
	       
	       Thread cacheService = new Thread(new Task("CacheService", 5000, latch));
	       Thread alertService = new Thread(new Task("AlertService", 3000, latch));
	       Thread validationService = new Thread(new Task("ValidationService", 2000, latch));
	       
	       cacheService.setName("CacheService");
	       alertService.setName("AlertService");
	       validationService.setName("ValidationService");
	       
	       cacheService.start(); //separate thread will initialize CacheService
	       alertService.start(); //another thread for AlertService initialization
	       validationService.start();
	      
	       // application should not start processing any thread until all tasks are up
	       // and ready to do their job.
	       // Countdown latch is idle choice here, main thread will start with count 3
	       // and wait until count reaches zero. each thread once up and read will do
	       // a count-down. this will ensure that main thread is not started processing
	       // until all services is up.
	        
	       try{
	    	   System.out.println("Thread.currentThread() is "+Thread.currentThread().getName());
	            latch.await();  //main thread is waiting on CountDownLatch to finish
	            System.out.println("All services are up, Application is starting now");
	       } catch(Exception ie){
	    	   System.out.println("interrupted into main thread");
	           ie.printStackTrace();
	       }
	    }
}
