package pancakes;

public class CampsitePancakeCooking implements PancakeCooking {

    private int butter = 20;
    private int plates = 4;

    @Override
    public synchronized void takeBakingPlate(String name) {
        while(plates <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        plates--;
        System.out.println(name+ " is taking a plate. " + plates + " plate has left ");
        notifyAll();
    }

    @Override
    public synchronized void pourBatterOnBakingPlate(String name) {
        while(butter <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        butter--;
        System.out.println(name + " is taking a butter. " +  butter + " butter has left");
        notifyAll();
    }

    @Override
    public synchronized void mixABowlOfPancakeBatter() {
        System.out.println("Owner is mixing a bowl of pancake");
        while (butter > 3)
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public synchronized void putBackBakingPlate(String name) {
        plates++;
        System.out.println(name + " is returning plate. " + "Plate was return. Number of plates : " + plates);
        notifyAll();
    }

    @Override
    public synchronized void refillBowl() {
            butter = 20;
        System.out.println("Bowl of butter was refill.");
            notifyAll();
    }


}
