package ex1;

public class RoadMain {

    public static void main(String[] args) {

        Bridge bridge = new Bridge();
        BlueCar car1 = new BlueCar(bridge);
        BlueCar car2 = new BlueCar(bridge);
        RedCar car3 = new RedCar(bridge);
        RedCar car4 = new RedCar(bridge);
        RedCar car5 = new RedCar(bridge);
        RedCar car6 = new RedCar(bridge);
        RedCar car7 = new RedCar(bridge);
        RedCar car8 = new RedCar(bridge);

        new Thread(car3).start();
        new Thread(car6).start();
        new Thread(car4).start();
        new Thread(car2).start();
        new Thread(car8).start();
        new Thread(car7).start();
        new Thread(car1).start();
        new Thread(car5).start();

    }
}
