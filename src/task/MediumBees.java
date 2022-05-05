package task;

public class MediumBees implements Runnable {
    private int work = 2;

    public MediumBees() {
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag){
            synchronized (Main.locker) {
                if (Main.count < Main.potOfhoney) {
                    Main.count += work;
                    System.out.println("MediumBees " + Main.count);
                }else {
                    flag = false;
                }
            }
        }
        try {
            synchronized (Main.locker){
                System.out.println("MediumBees заснула");
                Main.locker.notifyAll();
                Main.locker.wait();}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
