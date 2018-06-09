package ex2;

public class ToiletBuilding implements PublicToilet {

    private int user;
    private int cabins;
    private boolean cleaning;

    public ToiletBuilding() {
        cabins = 5;
        cleaning = false;
    }

    @Override
    public synchronized void stepIntoCabin(String name) {
        while (cabins <= 0) {
            try {
                System.out.println("Cabins are occupied. You have to wait.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cabins--;
        System.out.println(name + " is using toilet. Number of free cabins: " + cabins);
        notify();
    }

    @Override
    public synchronized void leaveCabin(String name) {
        cabins++;
        System.out.println(name + " has left the toilet. Number of free cabins: " + cabins);
        notifyAll();
    }

    @Override
    public synchronized void startWashingHands(String name) {
        System.out.println(name + " is washing hands.");
    }

    @Override
    public synchronized void stopWashingHands(String name) {
        System.out.println(name + " has stop washing hands.");
    }

    @Override
    public synchronized void cleanToilets() {
        while (cleaning) {
            cabins = 0;
            System.out.println("Cleaner is cleaning toilets.");
        }
        notifyAll();
    }

    @Override
    public synchronized void endCleaningToilets() {
        cleaning = false;
        cabins = 5;
        System.out.println("Toilets are clean.");
        notifyAll();
    }
}
