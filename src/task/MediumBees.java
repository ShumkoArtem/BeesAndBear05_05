package task;

public class MediumBees implements Runnable {
    private int work = 2;

    public MediumBees() {
    }

    @Override
    public void run() {
        while (Main.potOfhoney > Main.count) {
            Main.count += work;
            System.out.println("MediumBees " + Main.count);
        }
        try {
            this.wait();
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
