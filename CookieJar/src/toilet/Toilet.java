package toilet;

public class Toilet {

    private int number;
    private static int nextNumber = 0;

    public Toilet(){
        number = ++nextNumber;
    }

    public int number() {
        return  number;
    }
}
