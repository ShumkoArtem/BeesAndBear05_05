package task;

public class BigBees implements Runnable {
    private int work = 3;

    public BigBees() {
    }

    @Override
    public void run() {
        while (Main.potOfhoney > Main.count) {
            Main.count += work;
            System.out.println("BigBees " + Main.count);
        }
        try {
            this.wait();
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
