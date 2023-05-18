public class ATM {

    private int summPrevious = 100000;

    public void withdrawalOfMoney(String name, int summ){
        System.out.println(name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (summPrevious>=summ){
            int ost = summPrevious - summ;
            System.out.printf("%s, вывел %d. В банкомате осталось %d рублей \n",name,summ,ost);
        }
        else {
            System.out.println("В банкомате недостаточно деняг(");
        }
    }
}
