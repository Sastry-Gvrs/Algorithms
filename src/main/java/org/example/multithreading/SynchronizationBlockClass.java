package org.example.multithreading;


/**
 * This is to demonstrate synchronized block at class and object level
 *
 * Output
 * Class level synchronization
 * Thread thread1Incremented j - 1
 * Thread thread2Incremented j - 2
 * Thread thread3Incremented j - 3
 * Thread thread4Incremented j - 4
 * --------------------------------------------------------
 * Object level Synchronization.
 * Thread thread1 Incremented i - 2
 * Thread thread2 Incremented i - 3
 * Thread thread3 Incremented i - 4
 * Thread thread4 Incremented i - 4
 *
 */
public class SynchronizationBlockClass {

    static int i;
    static int j;

    void incrementIObjectSynchronized() {
        synchronized (this) {
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " Incremented i - " + i);
        }
    }

    void incrementIClassSynchronzied() {
        synchronized (SynchronizationBlockClass.class) {
            j++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread " + Thread.currentThread().getName() + "Incremented j - " + j);
        }
    }


    public static void main(String[] args) {
        SynchronizationBlockClass synchronizationBlockClass = new SynchronizationBlockClass();

        SynchronizationBlockClass synchronizationBlockClass1 = new SynchronizationBlockClass();

        Thread thread1 = new Thread(() -> synchronizationBlockClass.incrementIClassSynchronzied());
        Thread thread2 = new Thread(() -> synchronizationBlockClass1.incrementIClassSynchronzied());
        Thread thread3 = new Thread(() -> synchronizationBlockClass.incrementIClassSynchronzied());
        Thread thread4 = new Thread(() -> synchronizationBlockClass1.incrementIClassSynchronzied());

        thread1.setName("thread1");
        thread2.setName("thread2");
        thread3.setName("thread3");
        thread4.setName("thread4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }





        thread1 = new Thread(() -> synchronizationBlockClass.incrementIObjectSynchronized());
        thread2 = new Thread(() -> synchronizationBlockClass1.incrementIObjectSynchronized());
        thread3 = new Thread(() -> synchronizationBlockClass1.incrementIObjectSynchronized());
        thread4 = new Thread(() -> synchronizationBlockClass.incrementIObjectSynchronized());

        thread1.setName("thread1");
        thread2.setName("thread2");
        thread3.setName("thread3");
        thread4.setName("thread4");

        System.out.println("--------------------------------------------------------");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
