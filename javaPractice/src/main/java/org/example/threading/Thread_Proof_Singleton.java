package org.example.threading;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

class BreakSingletonTask implements Runnable{

    private ThirdSingleton_with_Double_Check obj;

    @Override
    public void run() {
        for(int i=1;i<=5;i++){
           obj= ThirdSingleton_with_Double_Check.getInstance();
        }
       /* try {
            obj.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }*/
    }
}

//thread singleton 1

/**
 * ⚠️ The problem(s) with this approach
 * Performance Bottleneck
 * Since getInstance() is synchronized, every call (even after the instance is created) has to acquire a lock.
 * This makes the method unnecessarily slow in multi-threaded environments when many threads repeatedly call getInstance().
 * Example: Objects.isNull(instance) will be false after the first call, but still, synchronization happens on every invocation.
 * 🔎 Consequence: Synchronization overhead when it's not needed anymore.
 */
class SecondSingleton {

    private static SecondSingleton instance;

    private SecondSingleton(){
        System.out.println("default constructor...........");
    }

    public synchronized static SecondSingleton getInstance(){
        if(Objects.isNull(instance)) {
            System.out.println("1");
            instance = new SecondSingleton();
        }
        System.out.println("2");
        return instance;
    }
}

//thread singleton 2
//full proof singleton
class ThirdSingleton_with_Double_Check implements Cloneable, Serializable {

    private static volatile ThirdSingleton_with_Double_Check instance;

    private ThirdSingleton_with_Double_Check() {
        System.out.println("default constructor...........");
        if(instance != null){  // reflection proof
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ThirdSingleton_with_Double_Check getInstance(){
        if(instance == null) {
            System.out.println("1");
           synchronized (ThirdSingleton_with_Double_Check.class) {
               if(instance == null){
                   instance = new ThirdSingleton_with_Double_Check();
               }
           }
        }
        System.out.println("2");
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }

    @Serial
    public Object readResolve(){
        return instance;
    }
}

public class Thread_Proof_Singleton {

    public static void main(String... r){
       // System.out.println(FirstSingleton.getInstance().hashCode());
       // System.out.println( FirstSingleton.getInstance().hashCode());

        Thread t1 = new Thread(new BreakSingletonTask());
        Thread t2 = new Thread(new BreakSingletonTask());
        Thread t3 = new Thread(new BreakSingletonTask());
        Thread t4 = new Thread(new BreakSingletonTask());
        Thread t5 = new Thread(new BreakSingletonTask());
        Thread t6 = new Thread(new BreakSingletonTask());
        Thread t7 = new Thread(new BreakSingletonTask());
        Thread t8 = new Thread(new BreakSingletonTask());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t5.start();
        t6.start();
        t7.start();
        t8.start();

    }
}
