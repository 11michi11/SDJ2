package presentation;

public class Reader implements Runnable {

    private ReadWrite lock;

    public Reader(ReadWrite lock) {
        this.lock = lock;
    }

    public void run() {
        while (true) {
            waiting(2);
            lock.acquireRead();
            waiting(5);
            lock.releaseRead();
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
