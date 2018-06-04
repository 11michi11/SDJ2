package ex1;

public class RedCar implements Runnable {

    private Bridge road;

    public RedCar(Bridge road) {
        this.road = road;
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
            road.enterFromTheRight();
            waiting(3);
            road.exitToTheLeft();
            waiting(3);
        }
    }
}
