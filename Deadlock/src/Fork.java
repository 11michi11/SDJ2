import java.util.Random;

public class Fork {

    private int id;
    private static int nextId = 0;
    private boolean isTaken;

    public Fork() {
        this.id = ++nextId;
        this.isTaken = false;
    }

    public synchronized void getFork(int id){
        while(isTaken){
            try {
                System.out.println("Phil" + id + " is waiting for fork " + this.id);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Phil" + id + " took fork " + this.id);
        isTaken = true;
        notify();
    }

    public synchronized void putBackFork(){
        System.out.println("Phil" + id + " is putting back fork " + this.id);
        isTaken = false;
        notify();
    }

    public int getId() {
        return id;
    }
}
