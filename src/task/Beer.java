package task;

public class Beer implements Runnable {

    @Override
    public void run() {

        synchronized (Main.locker) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Медведь проснулся!!!!!");
            Main.count = 0;
        }
        try {
            System.out.println("Медведь съел весь мед и уснул...");
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
