package task;

public class MediumBees extends Bees {
    private int workBeeMedium = 2;
    private double total; // количество меда собранного этой пчелой

    public MediumBees() {
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag){
            this.total += workBeeMedium;
            synchronized (Main.locker) { // синхронизируем объекты
                if (Main.count < Main.potOfhoney) {
                    Main.count += workBeeMedium;

                   // System.out.println("MediumBees " + Main.count);
                }else {
                    flag = false;
                    System.out.println("Medium Bee собрала : " + (total / 10) + "% меда" );
                }
//                    try {
//                        System.out.println("MediumBees заснула");
//                        locker1.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        }

    }
}
