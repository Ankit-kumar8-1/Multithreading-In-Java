package MultiThreadingInJava;

import com.sun.source.tree.Tree;

import javax.swing.plaf.TableHeaderUI;
import java.sql.SQLOutput;

public class ThreadMethods extends Thread {

    public ThreadMethods(String name) {
        super(name);
    }

    @Override
    public void run() {
        // running method
        // System.out.println("Threading is running ....");
        //

        // sleep method
        /*
         * for(int i=1;i<=5;i++){
         * try {
         * Thread .sleep(1000);
         * } catch (InterruptedException e) {
         * throw new RuntimeException(e);
         * }
         * System.out.println(i);
         * }
         */

        // Priority
        /*
         * for(int i=0;i<5;i++){
         * String a = "";
         * for(int j=0;j<10000;j++){
         * a+="a";
         * }
         * System.out.println(Thread.currentThread().getName() + " priority :" +
         * Thread.currentThread().getPriority() + " count :" + i );
         * try
         * {
         * Thread.sleep(100);
         * }catch (Exception e ){
         * 
         * }
         * }
         */

        // Yield Method
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is Running ");
            Thread.yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("learning Method ...");
        // ThreadMethods t1 = new ThreadMethods();
        //// start methods
        // t1.start();
        //// join method
        // t1.join();
        // System.out.println("Hello");

        // set priority
        /*
         * ThreadMethods l = new ThreadMethods("Low priority Thread ");
         * ThreadMethods m = new ThreadMethods("Medium priority Thread ");
         * ThreadMethods n = new ThreadMethods("High priority Thread ");
         * l.setPriority(Thread.MIN_PRIORITY);
         * n.setPriority(Thread.MIN_PRIORITY);
         * l.setPriority(Thread.MIN_PRIORITY);
         * l.start();
         * m.start();
         * n.start();
         */

        // Interrupt mehtod Explore : eska matlb hai ke tum jo be kaam kar rahe ho us
        // kaam ko rok do
        /*
         * Thread t1= new Thread(()->{
         * try
         * {
         * System.out.println("Thread is going to sleep ");
         * Thread.sleep(5000);
         * System.out.println("Thread woke up naturally ");
         * }catch (InterruptedException e){
         * System.out.println("Thread was interrupted during sleep ");
         * }
         * });
         * 
         * t1.start();
         * try{
         * Thread.sleep(1000);
         * }catch (InterruptedException e){}
         * t1.interrupt();
         */

        // Yield Method : eka matlb ye hai ke ye bolta hai aap dusre thread ko b echance
        // do chalne ke lea m side hat jaunga , nahi stop hota nahi waiting m jata
        /*
         * ThreadMethods t1 = new ThreadMethods("T1");
         * ThreadMethods t2 = new ThreadMethods("T2");
         * t1.start();
         * t2.start();
         */

        // setDeamon Methods (Background thread )
        Thread t1 = new Thread(() -> {
            System.out.println("Worker thread started ");
            try {
                Thread.sleep(3000);
                System.out.println("Worker thread is completed ");
            } catch (Exception e) {
            }

        });

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("Deamon thread running ");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        });

        t2.setDaemon(true);
        t1.start();
        t2.start();

        // Methods : start run sleep join setPriority interrupt yield
    }
}
