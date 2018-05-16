package toilet;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ToiletBuilding implements PublicToilet {

    private BlockingQueue<Toilet> toilets;
    private BlockingQueue<Faucet> faucets;
    private BlockingQueue<Dryer> dryers;

    public ToiletBuilding(int numOfToiltets, int numOfFaucets, int numOfDryers) {
        toilets = new LinkedBlockingQueue<>(numOfToiltets);
        faucets = new LinkedBlockingQueue<>(numOfFaucets);
        dryers = new LinkedBlockingQueue<>(numOfDryers);

        for (int i = 0; i < numOfToiltets; i++) {
            toilets.add(new Toilet());
        }

        for (int i = 0; i < numOfFaucets; i++) {
            faucets.add(new Faucet());
        }

        for (int i = 0; i < numOfDryers; i++) {
            dryers.add(new Dryer());
        }
    }


    @Override
    public Toilet stepIntoCabin(String person) {
        try {
            System.out.println(person + " has entered the queue to toilets");
            Toilet t = toilets.take();
            System.out.println(person + " has entered the toilet number " + t.number());
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void leaveCabin(Toilet toilet, String name) {
        try {
            System.out.println(name + " has left toilet " + toilet.number());
            toilets.put(toilet);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Faucet startWashingHands(String person) {
        try {
            System.out.println(person + " has entered the queue to faucets");
            Faucet f = faucets.take();
            System.out.println(person + " has entered the faucet number " + f.number());
            return f;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void stopWashingHands(Faucet faucet, String name) {
        try {
            System.out.println(name + " has left faucet " + faucet.number());
            faucets.put(faucet);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dryer startDryingHands(String person) {
        try {
            System.out.println(person + " has entered the queue to dryers");
            Dryer d = dryers.take();
            System.out.println(person + " has entered dryer number" + d.number());
            return d;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void stopDryingHands(Dryer dryer, String name) {
        try {
            System.out.println(name + " has left dryer " + dryer.number());
            dryers.put(dryer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
