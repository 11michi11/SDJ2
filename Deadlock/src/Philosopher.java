import java.util.Random;

public class Philosopher implements Runnable {

    private Fork leftFork, rightFork;
    private int id;
    private static int nextId = 0;
    private Random rn = new Random();

    public Philosopher(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        id = ++nextId;
    }

    @Override
    public void run() {
        while (true) {
            doSomething("THINK", 5);
            if(leftFork.getId() < rightFork.getId()) {
                leftFork.getFork(id);
                rightFork.getFork(id);
            }else{
                rightFork.getFork(id);
                leftFork.getFork(id);
            }
            doSomething("EAT", 3);
            rightFork.putBackFork();
            leftFork.putBackFork();
        }
    }

    private void doSomething(String action, int sec) {
        System.out.println("Phil" + id + " is in action " + action);
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
