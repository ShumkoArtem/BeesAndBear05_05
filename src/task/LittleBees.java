package task;

public class LittleBees implements Runnable {

    private int workBee = 1; // сколько меда эта пчела приносит за один раз
    private int amount = 0; // количество меда собранного этой пчелой

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            synchronized (Main.locker) { // синхронизируем объекты
                if (Main.count < Main.potOfhoney) {
                    Main.count += workBee;
                    this.amount ++;
                    System.out.println("LittleBees " + Main.count);
                }else {
                    flag = false;
                }
            }
        }
        try {
            synchronized (Main.locker) {
                System.out.println("LittleBees заснула");
                Main.locker.notifyAll(); // будим другие потоки
                Main.locker.wait(); // засыпаем
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
