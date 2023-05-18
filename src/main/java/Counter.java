import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger value = new AtomicInteger();

    private final Object monitor = new Object();

    public int getValue() {
        return value.intValue();
    }

    public void inc() {
        value.getAndIncrement();
    }

    public void dec() {
        value.getAndDecrement();
    }
}
