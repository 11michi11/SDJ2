package toilet;

import java.util.Random;

public class Person implements  Runnable{

    private String name;
    private ToiletBuilding tb;
    private Random rn = new Random();

    public Person(String name, ToiletBuilding tb) {
        this.name = name;
        this.tb = tb;
    }

    @Override
    public void run() {
        Toilet t;
        Faucet f;
        Dryer d;
        while(true){
            t = tb.stepIntoCabin(name);
            waiting();
            tb.leaveCabin(t, name);
            f = tb.startWashingHands(name);
            waiting();
            tb.stopWashingHands(f, name);
            d = tb.startDryingHands(name);
            waiting();
            tb.stopDryingHands(d, name);
        }
    }

    private void waiting(){
        try {
            Thread.sleep(rn.nextInt(10) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
