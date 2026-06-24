package org.example.threading;


class CorrectTask implements Runnable{

    @Override
    public void run() {
        int i=0;
        i = 10 / 0;
        System.out.println(i);
    }
}

//wrong way of handling exception while working with threads.....
class WrongTask implements Runnable{

    @Override
    public void run() {
        int i=0;
       // try {
            i = 10 / 0;
      //  }catch (ArithmeticException e){
           // System.out.println("error");
       // }
        System.out.println(i);
    }
}

class DefaultTask implements Runnable{

    @Override
    public void run() {
        int i=0;
        i = 10 / 0;
        System.out.println(i);
    }
}
public class ExceptionHandling_In_Threading {

    public  static void main(String...e) {
        Thread.setDefaultUncaughtExceptionHandler(new DefaultThreadException());
        Thread t1 = new Thread(new WrongTask());
        t1.setName("Task10-T1");
        t1.start();

        Thread t2 = new Thread(new CorrectTask());
        t2.setName("Task10-T2");
       // t2.setUncaughtExceptionHandler(new HandleThreadException());
        t2.start();

        Thread t3 = new Thread(new CorrectTask());
        t3.setName("Task10-T3");
       // t3.setUncaughtExceptionHandler(new HandleThreadException1());
        t3.start();

        Thread t4 = new Thread(new DefaultTask());
        t4.setName("Task10-T4");
        t4.start();

    }
}

class HandleThreadException implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("t is "+t);
        System.out.println("e "+e);
    }
}

class HandleThreadException1 implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("error ocurred.. send mail..");
    }
}

class DefaultThreadException implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("error ocurred, send mail and sms to customer by default exception handler........");
    }
}

