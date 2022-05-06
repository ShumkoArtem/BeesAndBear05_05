package task;

public class BigBees extends Bees {
    private int workBeeBig = 3;
    private double total; // количество меда собранного этой пчелой

    public BigBees() {
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            this.total += workBeeBig;
            synchronized (Main.locker) { // синхронизируем объекты
                if (Main.count < Main.potOfhoney) {
                    Main.count += workBeeBig;
                   // System.out.println("BigBees " + Main.count);
                }else {
                    flag = false;
                    System.out.println("Big Bee собрала : " + (total / 10) + "% меда" );
                }
//                    try {
//                        System.out.println("BigBees заснула");
//                        locker1.notifyAll();
//                        locker1.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        }

    }
}
