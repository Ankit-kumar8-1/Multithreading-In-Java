package MultiThreadingInJava;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountExplicitExample {
    private int balance = 100;
    private Lock lock = new ReentrantLock();

    public void Withdrow(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Attampting to withdraw " + amount);

        try {

            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {

                        System.out.println(Thread.currentThread().getName() + " processing with withdrawing ");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(
                                Thread.currentThread().getName() + " Complete withdrawal . remaning  : " + balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " Insufficent balance ");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock will be later ");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {

        BankAccountExplicitExample bank = new BankAccountExplicitExample();

        Thread user1 = new Thread(() -> {
            try {
                bank.Withdrow(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread user2 = new Thread(() -> {
            try {
                bank.Withdrow(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        user1.start();
        user2.start();

    }
}
