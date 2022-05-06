package task;

public class Beer implements Runnable {

    @Override
    public void run() {
        synchronized (Main.locker) {
            try {
                System.out.println("Медведь спит");
                Main.locker.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (Main.count >= Main.potOfhoney) {
                System.out.println("Медведь проснулся!!!!!");
                while (Main.count > 0) {
                    Main.count -= 100;
                    System.out.println("Медведь ест мед, меда в горшке осталось : " + Main.count);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Медведь съел весь мед и уснул...");

                synchronized (Main.locker) {
                    Main.locker.notifyAll();
                    try {
                        Main.locker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
