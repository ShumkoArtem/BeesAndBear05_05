package task;

public class Bees implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            Thread l1 = new Thread(new LittleBees());
            Thread l2 = new Thread(new MediumBees());
            Thread l3 = new Thread(new BigBees());

            l1.start();
            l2.start();
            l3.start();

            while (Main.count < Main.potOfhoney) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Горшок заполнен медом!!! ");

            synchronized (Main.locker) {
                try {
                    Main.locker.notify();
                    Main.locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (i < 2) {
                System.out.println("Пчелы проснулись");
            }
        }

    }

}
