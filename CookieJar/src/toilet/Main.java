package toilet;

public class Main {

    public static void main(String[] args) {
        ToiletBuilding tb = new ToiletBuilding(2, 3, 1);
        new Thread(new Person("name1", tb)).start();
        new Thread(new Person("name2", tb)).start();
        new Thread(new Person("name3", tb)).start();
        new Thread(new Person("name4", tb)).start();
        new Thread(new Person("name5", tb)).start();
        new Thread(new Person("name6", tb)).start();
        new Thread(new Person("name7", tb)).start();
    }

}
