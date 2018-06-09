package parking;

public class Garage implements ParkingPlace{
    private int numberOfPlaces = 5;

    public Garage() {
    }
    @Override
    public synchronized void arrive(String name) {
        while (numberOfPlaces <= 0){
            try {
                System.out.println(name + " is waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numberOfPlaces--;
        System.out.println(name + " has arrived, " + numberOfPlaces + " are left");
        notifyAll();
    }

    @Override
    public synchronized void leave(String name) {
        System.out.println(name + " has left");
        numberOfPlaces++;
        notifyAll();
    }

    @Override
    public synchronized int freePlaces() {
        return numberOfPlaces;
    }
}
