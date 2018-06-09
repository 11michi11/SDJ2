package ex1;

public class Bridge implements Lane {

    private int leftCar;
    private int rightCar;
    private int waitingCars;

    public Bridge() {
        leftCar = 0;
        rightCar = 0;
        waitingCars = 0;
    }

    @Override
    public synchronized void enterFromTheLeft() {

        waitingCars++;
        while(rightCar > 0 ) {
            try {
                wait();
                System.out.println("blue car is waiting. Number of blue cars: " + leftCar + " Number of red cars: " + rightCar + " Number of waiting cars " + waitingCars);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waitingCars--;
        leftCar++;
        notify();
    }

    @Override
    public synchronized void exitToTheRight() {
        leftCar--;
        notifyAll();
        System.out.println("Blue car is going to the right side. Number of blue cars: " + leftCar + " Number of red cars: " + rightCar);
    }

    @Override
    public synchronized void enterFromTheRight() {

        while (leftCar > 0 || waitingCars > 0) {
            try {
                wait();
                System.out.println("red car is waiting. Number of red cars: " + rightCar + " Number of blue cars: " + leftCar );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        rightCar++;
        notify();
    }

    @Override
    public synchronized void exitToTheLeft() {
        rightCar--;
        notifyAll();
        System.out.println("Red car is going to the left side. Number of red cars: " + rightCar + " Number of blue cars: " + leftCar);

    }
}
