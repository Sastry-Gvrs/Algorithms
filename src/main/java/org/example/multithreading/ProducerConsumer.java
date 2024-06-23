package org.example.multithreading;

public class ProducerConsumer {

    static int i =0;

    private static boolean produced;
    private static boolean consumed = false;


    void produce() {
        synchronized (this) {
            while (true) {
                if (consumed) {
                    i++;
                    System.out.println("Producer produced : " + i);
                    consumed = false;
                    notify();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    void consume() {
        synchronized (this) {
            while(true) {
                if (produced) {
                    System.out.println("Consumer consumed : " + i);
                    consumed = true;
                    notify();
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static {
        i++;
        produced = true;
        System.out.println("Producer produced : " + i);
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producerThread = new Thread(() -> producerConsumer.produce());

        Thread consumerThread = new Thread(() -> producerConsumer.consume());

        producerThread.start();
        consumerThread.start();
    }
}
