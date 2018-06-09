package washing;

public class Main {

    public static void main(String[] args) {
        WashingHall wh = new WashingHall(3);
        new Thread(new Car("car1", wh)).start();
        new Thread(new Car("car2", wh)).start();
        new Thread(new Car("car3", wh)).start();
        new Thread(new Car("car4", wh)).start();
        new Thread(new Car("car5", wh)).start();
        new Thread(new Car("car6", wh)).start();
    }

}
