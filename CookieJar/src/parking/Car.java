package parking;

import java.util.Random;

public class Car implements Runnable {
    private String name;
    private Garage garage;

    private Random rn = new Random();

    public Car(String name, Garage garage) {
        this.name = name;
        this.garage = garage;
    }

    public void arrive() {
        garage.arrive(name);
    }

    public void leave() {
        garage.leave(name);
    }

    public void drive() {
        sleep(rn.nextInt(10));
    }

    public void park() {
        sleep(rn.nextInt(10));
    }

    private void sleep(int sec){
        try {
            Thread.sleep(sec *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            drive();
            arrive();
            park();
            leave();
        }
    }
}
