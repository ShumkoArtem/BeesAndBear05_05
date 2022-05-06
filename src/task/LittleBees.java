package task;

public class LittleBees extends Bees {

    private int workBee = 1; // сколько меда эта пчела приносит за один раз
    private double total; // количество меда собранного этой пчелой

    @Override
    public void run() {

        boolean flag = true;
        while (flag) {
            this.total += workBee;
            synchronized (Main.locker) { // синхронизируем объекты

                if (Main.count < Main.potOfhoney) {

                    Main.count += workBee;
                    //System.out.println("LittleBees " + Main.count);
                }else {
                    flag = false;
                    System.out.println("Little Bee собрала : " + (total / 10) + "% меда" );
                }
//                    try {
//                        System.out.println("LittleBees заснула");
//                        locker1.wait(); // засыпаем
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        }

    }
}
