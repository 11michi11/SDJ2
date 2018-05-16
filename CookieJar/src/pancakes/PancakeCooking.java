package pancakes;

public interface PancakeCooking {
    // Take a baking plate (wait if there are no available baking plates)
    void takeBakingPlate(String name);
    // Pour a cup of batter on the baking plate (wait if there are not enough batter)
    void pourBatterOnBakingPlate(String name);
    // Start mixing pancake batter (wait until the bowl is almost empty)
    void mixABowlOfPancakeBatter();
    // Return a baking plate (notify the campers waiting for a baking plate)
    void putBackBakingPlate(String name);
    // Refill the bowl with a specified number of cups (notify the campers waiting for batter)
    void refillBowl();

}
