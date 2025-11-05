package MultiThreadingInJava;

import java.util.Scanner;

public class SynchronizationDemo {
    int balanced = 1000;

    public synchronized void withdrowingMoney(String name, int amout) {
        if (balanced >= amout) {
            System.out.println(name + " is withdrawing...");
            balanced -= amout;
            System.out.println(name + "  Complete withdrawing , and Remaining balanced  : " + balanced);
        } else {
            System.out.println("Sorry not enough balance ");
        }
    }

    public static void main(String[] args) {

        SynchronizationDemo bank = new SynchronizationDemo();

        Thread t1 = new Thread(() -> {
            bank.withdrowingMoney("Ankit", 700);
        });
        Thread t2 = new Thread(() -> {
            bank.withdrowingMoney("Amit", 700);
        });

        t1.start();
        t2.start();

        // --> Locking type (1)Intrinsic jo uper vala hai esko nolte hai (2) Explicit ,
    }
}
