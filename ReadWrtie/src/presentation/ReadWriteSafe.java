package presentation;

public class ReadWriteSafe implements ReadWrite {

    private int readers;
    private int writers;
    private int waitingWriters;

    public ReadWriteSafe() {
        readers = 0;
        writers = 0;
    }

    public synchronized void acquireRead() {
        while (writers > 0 || waitingWriters > 0) {
            try {
                wait(); // in a try-catch block (not shown here)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readers++;
    }

    public synchronized void releaseRead() {
        readers--;
        if (readers == 0) {
            notify(); // notify one waiting writer
        }
    }

    public synchronized void acquireWrite() {
        waitingWriters++;
        while (readers > 0 || writers > 0) {
            try {
                wait(); // in a try-catch block (not shown here)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waitingWriters--;
        writers++;
    }

    public synchronized void releaseWrite() {
        writers--;
        notifyAll(); // notify all waiting readers
    }
}