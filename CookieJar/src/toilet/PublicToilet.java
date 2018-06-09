package toilet;

public interface PublicToilet {
    // wait if there are no available cabins or if it is not your turn
    Toilet stepIntoCabin(String person);

    void leaveCabin(Toilet toilet, String name);

    // wait if there are no available faucets or if it is not your turn
    Faucet startWashingHands(String person);

    void stopWashingHands(Faucet faucet, String name);

    // wait if there are no available hand dryers or if it is not your turn
    Dryer startDryingHands(String person);

    void stopDryingHands(Dryer dryer, String name);
}