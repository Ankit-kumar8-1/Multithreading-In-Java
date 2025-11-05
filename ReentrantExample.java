package MultiThreadingInJava;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();

        try {
            System.out.println("Outer Method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock();
        try {
            System.out.println("inner Method ");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample r1 = new ReentrantExample();

        Thread t1 = new Thread(() -> {
            r1.outerMethod();

        });
        Thread t2 = new Thread(() -> {
            r1.outerMethod();
        });

        t1.start();
        t2.start();

    }
}
