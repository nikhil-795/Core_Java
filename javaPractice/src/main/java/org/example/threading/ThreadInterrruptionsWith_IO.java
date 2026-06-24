package org.example.threading;

import java.util.Scanner;

class IO_Not_Interruption implements Runnable{

    @Override
    public void run() {
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("please enter some value........");
            String str = scanner.nextLine();
            System.out.println("entered value is => "+str);
        }
    }
}

public class ThreadInterrruptionsWith_IO {
    public static void main(String... e){
        Thread t = new Thread( new IO_Not_Interruption());
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        t.interrupt();
        System.out.println("main thread is over");

    }
}
