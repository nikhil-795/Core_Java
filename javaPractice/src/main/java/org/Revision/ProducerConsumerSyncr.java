package org.Revision;

class Shared {
    int value;
    boolean available = false;

    public synchronized void produce(int v) {
        while (available) { // if already has value, wait
            try { wait(); } catch (Exception e) {}
        }
        value = v;
        available = true;
        System.out.println("Produced: " + v);
        notify(); // notify the consumer to wake up if waiting
    }

    public synchronized int consume() {
        while (!available) { // if no value, wait
            try { wait(); } catch (Exception e) {}
        }
        available = false;
        System.out.println("Consumed: " + value);
        notify(); // notify the producer to wake up if waiting
        return value;
    }
}

class Producer1 extends Thread {
    Shared s;
    Producer1(Shared s) { this.s = s; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            s.produce(i);
        }
    }
}

class Consumer1 extends Thread {
    Shared s;
    Consumer1(Shared s) { this.s = s; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            s.consume();
        }
    }
}

public class ProducerConsumerSyncr{
    public static void main(String[] args) {
        Shared obj = new Shared();
        new Producer1(obj).start();
        new Consumer1(obj).start();
    }
}

