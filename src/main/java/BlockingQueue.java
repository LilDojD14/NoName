import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private final Queue<Runnable> queue = new LinkedList<>();
    private final Object monitor = new Object();

    public void insertTask(Runnable r){
        synchronized (monitor) {
            queue.add(r);
            monitor.notify();
        }
    }

    public Runnable takeTask(){
        synchronized (monitor) {
            while (queue.isEmpty()) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return queue.poll();
        }
    }

}
