package parking;

public class ParkingTest {

    public static void main(String[] args) {

        Garage garage = new Garage();
        Car car1 = new Car("cintroen", garage);
        Car car2 = new Car("toyota", garage);
        Car car3 = new Car("ferarri", garage);
        Car car4 = new Car("skoda", garage);
        Car car5 = new Car("honda", garage);

        new Thread(car1).start();
        new Thread(car2).start();
        new Thread(car3).start();
        new Thread(car4).start();
        new Thread(car5).start();



    }
}
