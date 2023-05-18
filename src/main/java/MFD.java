import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MFD {

    public void scan(int pages){

        try {
            for (int i=1; i<=pages; i++){
                System.out.printf("Отсканировано %d стр%n",i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(int pages){
        try {
            for (int i=1; i<=pages; i++){
                System.out.printf("Отпечатано %d стр%n",i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
