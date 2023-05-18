public class Account {
    private int amount1;
    private int amount2;

    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();

    public Account(int amount1, int amount2) {
        this.amount1 = amount1;
        this.amount2 = amount2;
    }

    public void transferFrom1To2(int amount){
        synchronized (monitor1){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (amount1>=amount){
                System.out.println("Enough money");
                synchronized (monitor2) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    amount1-=amount;
                    amount2+=amount;
                }
            }else {
                System.out.println("Not enough money");
            }
        }
    }

    public void transferFrom2To1(int amount){
        synchronized (monitor2){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (amount2>=amount){
                System.out.println("Enough money");
                synchronized (monitor1) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    amount1+=amount;
                    amount2-=amount;
                }
            }else {
                System.out.println("Not enough money");
            }
        }
    }
}
