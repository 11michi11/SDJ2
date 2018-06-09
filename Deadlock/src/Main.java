public class Main {

    public static void main(String[] args) {
        Fork[] forks = new Fork[5];
        for (int i = 0; i < forks.length; i++)
            forks[i] = new Fork();

        for (int i = 0; i < forks.length; i++)
            new Thread(new Philosopher(forks[i], forks[(i + 1) % forks.length])).start();
    }

}
