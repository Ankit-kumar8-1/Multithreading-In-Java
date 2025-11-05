package MultiThreadingInJava;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class unfairLock {
    private final Lock unfairLook01 = new ReentrantLock(true);

    public void accessResourece() {
        unfairLook01.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock ");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            unfairLook01.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock ");
        }
    }

    public static void main(String[] args) {
        unfairLock example = new unfairLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResourece();
            }
        };

        Thread thread1 = new Thread(task, " Thread  1");
        Thread thread2 = new Thread(task, " thread   2");
        Thread thread3 = new Thread(task, "thread  3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
