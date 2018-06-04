package ex1;

public class BlueCar implements Runnable{

    private Bridge road;

    public BlueCar(Bridge road) {
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
            road.enterFromTheLeft();
            waiting(2);
            road.exitToTheRight();
            waiting(2);
        }
    }
}
