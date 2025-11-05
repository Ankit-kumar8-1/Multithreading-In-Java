package MultiThreadingInJava;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println(Thread.currentThread().getName());

        World world = new World(); // new state
        world.start(); // RUNNABLE

        for (int i = 0; i < 10; i++) {
            System.out.println("Hello");
        }
    }
}
