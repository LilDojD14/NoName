import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task {
    private static String nextLetter = "A";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Object monitor = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            while (!nextLetter.equals("A")) {
                                monitor.wait();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print("A");
                        nextLetter = "B";
                        monitor.notifyAll();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            while (!nextLetter.equals("B")) {
                                monitor.wait();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print("B");
                        nextLetter = "C";
                        monitor.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            while (!nextLetter.equals("C")) {
                                monitor.wait();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print("C");
                        nextLetter = "A";
                        monitor.notifyAll();
                    }
                }
            }
        }).start();
    }
}
