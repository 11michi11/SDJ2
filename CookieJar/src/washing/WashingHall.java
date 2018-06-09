package washing;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class WashingHall {

    private Queue<Hall> availableHalls;
    private AtomicInteger occupiedHalls;
    private final AtomicInteger numberOfWashingHalls;

    public WashingHall(int numberOfWashingHalls) {
        this.availableHalls = new LinkedBlockingQueue<>(numberOfWashingHalls);
        this.numberOfWashingHalls = new AtomicInteger(numberOfWashingHalls);
        for (int i = 0; i < numberOfWashingHalls; i++) {
            this.availableHalls.add(new Hall(i));
        }
    }

    /* Customer enters for washing the car. A customer waits if all
 washing places are occupied
 */
    public synchronized Hall enterForWashing(String name) {
        while (availableHalls.isEmpty()) {
            try {
                System.out.println(name + " is waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " has entered");
        occupiedHalls.addAndGet(1);
        notifyAll();
        return availableHalls.remove();
    }

    /* Car washing has finished and customer leaves the washing place
    so that the next waiting car can enter.
    */
    public synchronized void leaveWashing(Hall hall, String name) {
        System.out.println(name + " has left");
        occupiedHalls.addAndGet(-1);
        availableHalls.add(hall);
        notifyAll();
    }

    public synchronized int getFreePlaces() {
        return numberOfWashingHalls.addAndGet(0 - occupiedHalls.get());
    }
}
