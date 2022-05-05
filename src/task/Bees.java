package task;

public class Bees implements Runnable{

    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {

        Thread l1 = new Thread(new LittleBees());
        Thread l2 = new Thread(new MediumBees());
        Thread l3 = new Thread(new BigBees());

        l1.start();
        l2.start();
        l3.start();

        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.count >= Main.potOfhoney){
            System.out.println("Горшок полный");
        }

    }
}
