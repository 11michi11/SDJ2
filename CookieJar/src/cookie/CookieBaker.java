package cookie;

public class CookieBaker implements Runnable{

    private final int plateCapacity = 16;
    private CookieJar jar;
    private String name;

    public CookieBaker(CookieJar jar, String name){
        this.jar = jar;
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            if(jar.startBaking(name)){
                makingCookies();
                jar.finishedBaking(plateCapacity, name);
            }
        }
    }

    private void makingCookies(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
