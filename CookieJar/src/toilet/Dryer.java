package toilet;

public class Dryer {

    private int number;
    private static int nextNumber = 0;

    public Dryer(){
        number = ++nextNumber;
    }

    public int number() {
        return  number;
    }
}
