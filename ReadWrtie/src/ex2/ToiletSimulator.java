package ex2;

public class ToiletSimulator {

    public static void main(String[] args) {
        ToiletBuilding toilet = new ToiletBuilding();
        CleaningPerson cleaner = new CleaningPerson(toilet);
        new Thread(cleaner).start();

        for (int i = 0; i < 12; i++) {
            Person person = new Person("person" + i, toilet);
            new Thread(person).start();
        }

    }
}
