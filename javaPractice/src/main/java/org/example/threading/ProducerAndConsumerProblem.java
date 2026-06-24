package org.example.threading;


class BufferKit {

    int a;
    boolean isProduced;
    public synchronized void produce(int number) throws InterruptedException {
        while(isProduced){
            wait();
        }
        a = number;
        isProduced = true;
        System.out.println(Thread.currentThread()+" has produced the number a "+a);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while(!isProduced){
            wait();
        }
        isProduced = false;
        System.out.println(Thread.currentThread()+" has consumed the number a "+a);
        notify();
    }
}

class ProducerTask implements Runnable{

    private BufferKit bufferKit;
    ProducerTask(BufferKit bufferKit) {
        this.bufferKit = bufferKit;
    }
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            try {
                this.bufferKit.produce(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class ConsumerTask implements Runnable{

    private BufferKit bufferKit;
    ConsumerTask(BufferKit bufferKit){
        this.bufferKit = bufferKit;
    }

    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            try {
                this.bufferKit.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ProducerAndConsumerProblem {

    public static void main(String... s){
        BufferKit obj = new BufferKit();

        Thread t1 = new Thread(new ConsumerTask(obj));
        t1.setPriority(10);
        t1.start();

        Thread t2 = new Thread(new ProducerTask(obj));
        t2.setPriority(1);
        t2.start();
    }
}
