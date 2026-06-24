package org.example.concurrency.locks.reentrantlock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {

    private Lock l = new ReentrantLock();

    void show(){
        l.lock();
        System.out.println("trying to invoke show() method....");
        try {
           System.out.println("show() method called....");
       }finally {
           l.unlock();
            System.out.println("unlock show() method...");
       }
    }

    void display() {
        l.lock();
        System.out.println("trying to invoke display() method....");
        try {
            Thread.sleep(5000);
            System.out.println("display() method called....");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            l.unlock();
            System.out.println("unlock display() method...");
        }
    }
}


class T1 extends Thread{

    Resource r;

    T1(Resource r){
        this.r = r;
    }

    public void run(){

        for(int i=0;i<10;i++){

                r.display();

        }
    }

}

class T2 extends Thread{

    Resource r;

    T2(Resource r){
        this.r = r;
    }

    public void run(){

        for(int i=0;i<10;i++){
            r.show();
        }

    }
}


public class ReentrantLockTest {

    public static void main(String... e){
        Resource r = new Resource();

        T1 obj1 = new T1(r);
        obj1.setPriority(10);

        T2 obj2 = new T2(r);
        obj2.setPriority(1);

        obj1.start();
        obj2.start();

    }
}
