package ex2;

public interface PublicToilet {

    void stepIntoCabin(String name); // wait if there are no available cabins
    // or a cleaning person is ready to clean toilets
    void leaveCabin(String name);
    void startWashingHands(String name); // wait if there are no available faucets
    void stopWashingHands(String name);
    void cleanToilets(); // wait until all toilets are emptied
    void endCleaningToilets();
}
