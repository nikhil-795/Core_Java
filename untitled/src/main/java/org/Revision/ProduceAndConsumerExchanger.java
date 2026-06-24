package org.Revision;


    import java.util.concurrent.Exchanger;

    class Producer3 extends Thread {
        private Exchanger<Integer> exchanger;

        Producer3(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        public void run() {
            int value = 1;
            try {
                for(int i=0;i<10;i++){ // for loop
                    System.out.println("Producer produced: " + value);
                    // hand over directly to consumer
                    exchanger.exchange(value);
                    value++;
                    //Thread.sleep(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer3 extends Thread {
        private Exchanger<Integer> exchanger;

        Consumer3(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        public void run() {
            try {
                for(int i=0;i<10;i++) {
                    // wait until producer gives value
                    int item = exchanger.exchange(null);
                    System.out.println("Consumer consumed: " + item);
                    //Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

public class ProduceAndConsumerExchanger{
        public static void main(String[] args) {
            Exchanger<Integer> exchanger = new Exchanger<>();

            Producer3 p = new Producer3(exchanger);
            Consumer3 c = new Consumer3(exchanger);

            p.start();
            c.start();
        }
    }