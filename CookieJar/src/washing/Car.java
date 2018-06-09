package washing;

import java.util.Random;

public class Car implements  Runnable{

    private String name;
    private Hall hall;
    private WashingHall washingHall;
    private Random rn = new Random();


    public Car(String name, WashingHall washingHall) {
        this.name = name;
        this.washingHall = washingHall;
    }

    @Override
    public void run() {
        Hall hall;
        while(true){
            waiting();
            System.out.println("Free places " + washingHall.getFreePlaces());
            hall = washingHall.enterForWashing(name);
            waiting();
            washingHall.leaveWashing(hall, name);
        }
    }

    private void waiting(){
        try {
            Thread.sleep(rn.nextInt(10) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
