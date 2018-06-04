package presentation;

public class Writer implements Runnable {

    private ReadWrite lock;

    public Writer(ReadWrite lock) {
        this.lock = lock;
    }

    public void run() {
        while (true) {
            waiting(2);
            lock.acquireWrite();
            waiting(5);
            lock.releaseWrite();
            waiting(2);
        }
    }

    private void waiting(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
