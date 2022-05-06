package task;

public class Main {


    public static volatile int count = 0; // общее количество собранного меда
    public static int potOfhoney = 1000; // объем горшка для меда
    public static Object locker = new Object(); // технический объект для создания

    public static void main(String[] args) throws InterruptedException {

        Thread bees = new Thread(new Bees());
        Thread beer = new Thread(new Beer());

        bees.start();
        beer.start();






    }
}
