package pancakes;

public class Owner implements Runnable{

    private CampsitePancakeCooking cooking;

    public Owner(CampsitePancakeCooking cooking) {
        this.cooking = cooking;
    }

    public void makeAButter() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            cooking.mixABowlOfPancakeBatter();
            makeAButter();
            cooking.refillBowl();
        }
    }
}
