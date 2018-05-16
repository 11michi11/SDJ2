package pancakes;

public class Camper implements  Runnable{

    private String name;
    private CampsitePancakeCooking cooking;

    public Camper(String name, CampsitePancakeCooking cooking) {
        this.name = name;
        this.cooking = cooking;
    }
    public void eat(String name) {
        System.out.println(name + " is eating");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            cooking.takeBakingPlate(name);
            cooking.pourBatterOnBakingPlate(name);
            make(name);
            cooking.putBackBakingPlate(name);
            eat(name);
        }
    }


    private void make(String name){
        System.out.println(name + " is making a pancake");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
