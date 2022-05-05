package task;

public class LittleBees implements Runnable{

    private int workBee = 1;
    private int amount;

    @Override
    public void run() {
        while (Main.potOfhoney > Main.count) {
            Main.count += workBee;
            System.out.println("LittleBees " + Main.count);
        }
        try {
            this.wait();
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
