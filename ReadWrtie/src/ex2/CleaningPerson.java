package ex2;

public class CleaningPerson implements Runnable{
    private ToiletBuilding toilet;

    public CleaningPerson(ToiletBuilding toilet) {
        this.toilet = toilet;
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
            toilet.cleanToilets();
            waiting(10);
            toilet.endCleaningToilets();
        }
    }
}
