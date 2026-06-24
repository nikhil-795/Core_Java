package org.example.threading;

class A{
    public A(){
        Thread t = Thread.currentThread();
        System.out.println("A is created by "+t.getName() + " Thread");
    }
}

//user-defined Thread, it's not a task/job
class UserThread1 extends Thread{

     UserThread1(){
        Thread t = Thread.currentThread();
        System.out.println("UserThread1 is created by "+t.getName() + " Thread");
    }

    @Override
    public void run(){
        Thread t = Thread.currentThread();
        System.out.println("run is being executed by "+t.getName() + " Thread");
        UserThread2 u2 = new UserThread2();
        u2.start();
    }

}

//user-defined Thread, it's not a task/job
class UserThread2  extends Thread{

    UserThread2(){
        Thread t = Thread.currentThread();
        System.out.println("UserThread2 is created by "+t.getName() + " Thread");
    }

    @Override
    public void run(){
        Thread t = Thread.currentThread();
        System.out.println("run from UserThread2 is being executed by "+t.getName() + " Thread");
    }
}

public class AccessMainThread {
    public static void main(String... e){
        Thread currentThred = Thread.currentThread();
        System.out.println("main thread "+currentThred.getName());
        System.out.println("main thread "+currentThred);
        System.out.println("main thread group "+currentThred.getThreadGroup());
        System.out.println("main thread priority "+currentThred.getPriority());

        new A();

        UserThread1 u =  new UserThread1();
        //u.run();//wrong way
        u.setName("UserDefined1 Thread");
        u.start();
    }
}
