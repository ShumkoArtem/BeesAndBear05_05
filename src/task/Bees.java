package task;

public class Bees implements Runnable {


    @Override
    public void run() {
        synchronized (Main.locker) {
            Thread l1 = new Thread(new LittleBees());
            Thread l2 = new Thread(new MediumBees());
            Thread l3 = new Thread(new BigBees());

            l1.start();
            l2.start();
            l3.start();
        }
//        try {
//            this.wait();
//            this.notifyAll();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (Main.count >= Main.potOfhoney) {
            System.out.println("Горшок полный -------------------------------");
        }

    }
}
