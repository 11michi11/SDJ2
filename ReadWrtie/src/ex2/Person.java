package ex2;

public class Person implements Runnable{

    private ToiletBuilding toilet;
    private String name;

    public Person(String name, ToiletBuilding toilet) {
        this.toilet = toilet;
        this.name = name;
    }

    private void waiting(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            toilet.stepIntoCabin(name);
            waiting(8);
            toilet.leaveCabin(name);
            waiting(1);
            toilet.startWashingHands(name);
            waiting(4);
            toilet.stopWashingHands(name);
        }
    }
}
