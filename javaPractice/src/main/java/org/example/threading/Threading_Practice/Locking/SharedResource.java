package org.example.threading.Threading_Practice.Locking;

public class SharedResource implements Runnable{
    private final Object lock = new Object(); // custom lock object

    public void methodA() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " entered methodA");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName() + " leaving methodA");
        }
    }

    public void methodB() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " entered methodB");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName() + " leaving methodB");
        }
    }

        @Override
        public void run() {
            methodA();
            methodB();
        }
}

class TestSharedResource {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(resource, "Thread-1");
        Thread t2 = new Thread(resource, "Thread-2");

        t1.start();
        t2.start();
    }
}

