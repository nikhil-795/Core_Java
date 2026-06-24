package org.example.threading.Threading_Practice;

    class Worker implements Runnable {
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {

                System.out.println("Thread is working...");

                //running = false;

            }
            System.out.println("Thread exiting gracefully.");
        }

        public void stop() {
            running = false;
        }
    }

public class ThreadStop {
        public static void main(String[] args) throws InterruptedException {
            Worker worker = new Worker();
            Thread t = new Thread(worker);
            t.start();

            Thread.sleep(2000);
            System.out.println("Requesting stop...");
            worker.stop();

            t.join();
            System.out.println("Main thread finished.");
        }
    }


