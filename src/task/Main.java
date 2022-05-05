package task;

public class Main {

    public static volatile int count = 0; // общее количество собранного меда
    public static int potOfhoney = 10000; // объем горшка для меда

    public static void main(String[] args) {

        Thread bees = new Thread(new Bees());
        bees.start();



    }
}
