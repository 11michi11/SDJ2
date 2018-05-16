package cookie;

public class Main {

    public static void main(String[] args) {
        CookieJar jar = new CookieJar();
        CookieBaker baker = new CookieBaker(jar, "Baker");
        CookieEater eater1 = new CookieEater(jar, "Eater1");
        CookieEater eater2 = new CookieEater(jar, "Eater2");
        CookieEater eater3 = new CookieEater(jar, "Eater3");

        new Thread(baker).start();
        new Thread(eater1).start();
        new Thread(eater2).start();
        new Thread(eater3).start();


    }
}
