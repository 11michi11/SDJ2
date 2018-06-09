package toilet;

public class Faucet {

    private int number;
    private static int nextNumber = 0;

    public Faucet(){
        number = ++nextNumber;
    }

    public int number() {
        return  number;
    }
}
