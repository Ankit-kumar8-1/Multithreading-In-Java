package MultiThreadingInJava;

public class MyThread {

    public static void main(String[] args) throws InterruptedException {

        // new state
        // Thread t = new Thread(()->{
        // System.out.println("Threading is running ");
        // });
        //
        // System.out.println("thread state before start : " + t.getState()) ;

        // RUNNABLE STATE
        // Thread t1 = new Thread(()->{
        // while (true);
        // });
        //
        // t1.start();
        // System.out.println("Thread state After start () : "+ t1.getState());

        // Runnning state
        // Thread t = new Thread(() -> {
        // System.out.println("Thread is running: " +
        // Thread.currentThread().getState());
        // });
        //
        // t.start();

        // Wating state
        /*
         * Thread t1 = new Thread(() -> {
         * try {
         * Thread.sleep(5000); // t1 will sleep for 5 sec
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         * });
         * 
         * Thread t2 = new Thread(() -> {
         * try {
         * t1.join(); // t2 will wait for t1
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         * });
         * 
         * t1.start();
         * t2.start();
         * 
         * Thread.sleep(100); // thoda wait karte hain t2 ko WAITING mein jaane dene ke
         * liye
         * System.out.println("State of t2: " + t2.getState()); // WAITING
         */

        Thread t1 = new Thread(() -> {
            System.out.println("Thread is working  ... ");
        });

        t1.start();
        Thread.sleep(100);
        System.out.println("Thread state after working : " + t1.getState());

    }
}
