package task;

public class BigBees implements Runnable {
    private int work = 3;

    public BigBees() {
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            synchronized (Main.locker) {
                if (Main.count < Main.potOfhoney) {
                    Main.count += work;
                    System.out.println("BigBees " + Main.count);
                }else {
                    flag = false;
                }
            }
        }
        try {
            synchronized (Main.locker) {
                System.out.println("BigBees заснула");
                Main.locker.notifyAll();
                Main.locker.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
