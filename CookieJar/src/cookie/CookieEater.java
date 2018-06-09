package cookie;

public class CookieEater implements  Runnable{

    private CookieJar jar;
    private String name;

    public CookieEater(CookieJar jar, String name){
        this.jar = jar;
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            jar.eat(name);
            eatCookie();
        }
    }

    private void eatCookie(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
