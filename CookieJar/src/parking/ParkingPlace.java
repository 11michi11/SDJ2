package parking;

public interface ParkingPlace {
    void arrive(String name);
    void leave(String name);
    int freePlaces();
}
