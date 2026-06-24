package org.Revision.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true); // fair policy
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    private final Lock readLock1 = lock.readLock();
    private final Lock writeLock2 = lock.writeLock();

    //Case 1) Multiple threads can obtain read-lock at the same time
    public void case1_ReadLock(String threadName) {
        try {
            readLock.lock();
            System.out.println(threadName + " acquired READ lock, ");
            Thread.sleep(1000);
            readLock.unlock();
            System.out.println(threadName + " released READ lock");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   /* Case 2) Multiple threads with write operation , but only one thread can access the resource
            at a time*/
    public void case2_WriteLock(String threadName) {
        try {
            writeLock.lock();
            System.out.println(threadName + " acquired WRITE lock, updating resource...");
            Thread.sleep(4000);
            writeLock.unlock();
            System.out.println(threadName + " released WRITE lock");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   /* Case 3) If write lock need to acquire by one thread and other thread need read lock at the same time,
    than only single lock would be acquired by threads( as per fairness policy if mentioned)
    either write/read lock and other thread needs to wait in the queue*/
    public void case3_ReadOrWrite(String threadName, boolean write) {
        try {
            if (write) {
                System.out.println("Inside write");
                writeLock.lock();
                System.out.println(threadName + " acquired WRITE lock");
                //Thread.sleep(5000);
                writeLock.unlock();
            } else {
                System.out.println("Inside read");
                readLock.lock();
                System.out.println(threadName + " acquired READ lock");
                Thread.sleep(5000);
                readLock.unlock();
            }
            System.out.println(threadName + " released lock");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   /* Case 4) If a thread t1 got the write lock on some resource and same thread t1 needs to have another
    write/read lock on the same resource or different method of the same resource this case is valid too*/
    public void case4_ReentrantWrite(String threadName )throws InterruptedException{
        writeLock.lock();
        System.out.println(threadName + ") acquired  first WRITE lock");
        writeLock2.lock();
        System.out.println(threadName + " trying to acquire WRITE lock again...");
       /* writeLock.lock();
        System.out.println(threadName + " acquired WRITE lock (2nd time - reentrant)");*/
         Thread.sleep(4000);
        // releasing both locks explicitly
        writeLock2.unlock();
        System.out.println("Lock 2 released");
        writeLock.unlock();
        System.out.println(threadName + " released 1st lock ");
    }

   /* Case 5) If a thread t1 got the read lock on the some resource and same thread t1 wants to get the
    write lock on same resource or different method of the same resource, so thread t1
    can't acheive this, first of all thread t1 need to release the read lock and than it can
    take the write lock*/
    public void case5_ReadThenWrite(String threadName) {
        readLock.lock();
        System.out.println(threadName + " acquired READ lock");
        System.out.println(threadName + " trying to acquire WRITE lock...");
        writeLock.lock(); //  it will not abe able to take lock-> block the code
        System.out.println(threadName + " acquired WRITE lock");
        // this will accure deadlock-> to solve it  first release the  readlock  then take write lock


    }
  /*  Case 6) If a thread t1 got the read lock on some resource and the same thread t1 wants to have readlock
    again on the either same or different methods of same resource than it is valid*/
    public void case6_ReentrantRead(String threadName) throws InterruptedException{
        readLock.lock();
        System.out.println(threadName + " acquired READ lock (1st time)");
        readLock1.lock();
        System.out.println(threadName + " acquired READ lock (2nd time)");
        Thread.sleep(4000);
        readLock1.unlock();
        System.out.println("release 2nd read lock");
        readLock.unlock();
        System.out.println(threadName + " released READ lock fully");
    }
/*    Case 7) If a thread t1 got the write lock on some resource and same thread t1 also need another write lock
    on different method on same resource or same method of same resource is also valid*/
    public void case7_ReentrantWriteDifferentMethods(String threadName) {
        writeLock.lock();
        System.out.println(threadName + " acquired WRITE lock (method1)");
        anotherWriteLock(threadName);
        writeLock.unlock();
        System.out.println(threadName + " released WRITE lock (method1)");
    }

    private void anotherWriteLock(String threadName) {
        writeLock2.lock();
        System.out.println(threadName + " acquired WRITE lock (method2)");
        writeLock2.unlock();
        System.out.println(threadName + " released WRITE lock (method2)");
    }
}
