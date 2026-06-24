package org.Revision.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;


class Case1Thread extends Thread {
    private ReentrantReadWriteLockDemo demo;
    private String name;

    public Case1Thread(ReentrantReadWriteLockDemo demo, String name) {
        this.demo = demo;
        this.name = name;
    }

    public void run() {
        demo.case1_ReadLock(name);
    }
}

class Case2Thread extends Thread {
    private ReentrantReadWriteLockDemo demo;
    private String name;

    public Case2Thread(ReentrantReadWriteLockDemo demo, String name) {
        this.demo = demo;
        this.name = name;
    }

    public void run() {
        demo.case2_WriteLock(name);
    }
}

class Case3Thread extends Thread {
    private ReentrantReadWriteLockDemo demo;
    private String name;
    private boolean write;

    public Case3Thread(ReentrantReadWriteLockDemo demo, String name, boolean write) {
        this.demo = demo;
        this.name = name;
        this.write = write;
    }

    public void run() {
        demo.case3_ReadOrWrite(name, write);
    }
}

class Case4Thread extends Thread {
    private ReentrantReadWriteLockDemo demo;
    private String name;

    public Case4Thread(ReentrantReadWriteLockDemo demo, String name) {
        this.demo = demo;
        this.name = name;
    }

    public void run() {
        try {
            demo.case4_ReentrantWrite(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Case5Thread extends Thread {
    private ReentrantReadWriteLockDemo demo;
    private String name;

    public Case5Thread(ReentrantReadWriteLockDemo demo, String name) {
        this.demo = demo;
        this.name = name;
    }

    public void run() {
        demo.case5_ReadThenWrite(name);
    }
}

class Case6Thread extends Thread {
    private ReentrantReadWriteLockDemo demo;
    private String name;

    public Case6Thread(ReentrantReadWriteLockDemo demo, String name) {
        this.demo = demo;
        this.name = name;
    }

    public void run() {
        try {
            demo.case6_ReentrantRead(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Case7Thread extends Thread {
    private ReentrantReadWriteLockDemo demo;
    private String name;

    public Case7Thread(ReentrantReadWriteLockDemo demo, String name) {
        this.demo = demo;
        this.name = name;
    }

    public void run() {
        demo.case7_ReentrantWriteDifferentMethods(name);
    }
}

public class ReentrantReadWriteLockPractice {
    public static void main(String[] args) {
    ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();

    Thread t1 = new Case1Thread(demo, "T1");
    Thread t2 = new Case1Thread(demo, "T2");

    Thread t3 = new Case2Thread(demo, "T3");
    Thread t4 = new Case2Thread(demo, "T4");

    Thread t5 = new Case3Thread(demo, "T5", false);   // read
    Thread t6 = new Case3Thread(demo, "T6", true);  // write

    Thread t7 = new Case4Thread(demo, "T7");


     Thread t8 = new Case5Thread(demo, "T8");

    Thread t9 = new Case6Thread(demo, "T9");

    Thread t10 = new Case7Thread(demo, "T10");

        //Case 1) Multiple threads can obtain read-lock at the same time
       //   t1.start();
        //  t2.start();

      /* Case 2) Multiple threads with write operation , but only one thread can access the resource
            at a time*/
    //t3.start();
    //t4.start();

  /* Case 3) If write lock need to acquire by one thread and other thread need read lock at the same time,
    than only single lock would be acquired by threads( as per fairness policy if mentioned)
    either write/read lock and other thread needs to wait in the queue*/

     /*   t5.setPriority(10);
        t5.start();

        t6.setPriority(1);
        t6.start();*/



        /* Case 4) If a thread t1 got the write lock on some resource and same thread t1 needs to have another
    write/read lock on the same resource or different method of the same resource this case is valid too*/
      //  t7.start();

        /* Case 5) If a thread t1 got the read lock on the some resource and same thread t1 wants to get the
    write lock on same resource or different method of the same resource, so thread t1
    can't acheive this, first of all thread t1 need to release the read lock and than it can
    take the write lock*/

   //t8.start();

          /*  Case 6) If a thread t1 got the read lock on some resource and the same thread t1 wants to have readlock
    again on the either same or different methods of same resource than it is valid*/
        // t9.start();

       /* Case 7) If a thread t1 got the write lock on some resource and same thread t1 also need another write lock
        on different method on same resource or same method of same resource is also valid*/
   t10.start();
}
}

