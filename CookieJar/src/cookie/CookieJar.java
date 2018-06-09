package cookie;

public class CookieJar {

    private int numberOfCookies = 0;

    public synchronized boolean startBaking(String name){
        while(numberOfCookies >= 5) {
            try {
                System.out.println(name + " is waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public synchronized void finishedBaking(int plateCapacity, String name){
        numberOfCookies += plateCapacity;
        System.out.println(name + " finished baking, " + numberOfCookies + " cookies in the jar");
        notifyAll();
    }

    public synchronized void eat(String name){
        while(numberOfCookies <= 0) {
            try {
                System.out.println(name + " is waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " is eating, " + numberOfCookies + " cookies in the jar");
        numberOfCookies--;
        notifyAll();
    }


}