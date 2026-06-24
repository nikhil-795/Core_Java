package org.example.threading.Threading_Practice;

    class InterruptibleWorker implements Runnable {
        @Override
        public void run() {

                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Working...");
                }
        }
    }

    public class ThreadStopInterrup {
        public static void main(String[] args) throws InterruptedException {
            Thread t = new Thread(new InterruptibleWorker());
            t.start();

            Thread.sleep(2000);
            System.out.println("Interrupting thread...");
            t.interrupt();
            t.join();
            System.out.println("Main finished.");
        }
    }
