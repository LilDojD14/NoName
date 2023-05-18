import java.util.ArrayList;
import java.util.List;

public class Rem {

    private static List<String> list;

    public static void main(String[] args){
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        List<Integer> list3 = new ArrayList<>();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                list = new ArrayList<>();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(list.size());
            }
        });
       thread1.start();
       thread2.start();
    }
}
