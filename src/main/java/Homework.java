import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.*;

public class Homework {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Semaphore semaphore = new Semaphore(3);
        for (int i =0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String name = Thread.currentThread().getName();
                    System.out.println(name + " started work ");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        semaphore.acquire();
                        workWithFileSystem();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }finally {
                        semaphore.release();
                    }
                    System.out.println(name + " finished work ");
                }
            }).start();
            executorService.shutdown();
        }
    }

    private static void workWithFileSystem(){
        String name = Thread.currentThread().getName();
        System.out.println(name + " started work with file");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " finished work with file");
    }
}
