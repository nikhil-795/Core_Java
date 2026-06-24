package org.example.threading.Threading_Practice;

class Thread1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Running Thread1");
    }
}

public class GetClassMethod {


    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        t.setName("Main Thread");
        System.out.println(t);
        System.out.println(t.getClass());
        System.out.println(t.getClass().getName());

        Thread T1= new Thread(new Thread1());
        T1.setName("Thread-1");
        T1.start();

        Class<?> threadClass = T1.getClass();
        System.out.println("\nMeta data of T1: " + threadClass);
        System.out.println("\nClass of T1: " + threadClass.getName());
        System.out.println("\nPrinting all the methods of Thread class:");
        for(var method : threadClass.getMethods()){
            System.out.println(method.getName());
        }
    }
}
