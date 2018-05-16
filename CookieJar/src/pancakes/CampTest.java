package pancakes;

public class CampTest {

    public static void main(String[] args) {
        CampsitePancakeCooking cooking = new CampsitePancakeCooking();
        Owner owner = new Owner(cooking);
        Camper c1 = new Camper("Samuel Jackson", cooking);
        Camper c2 = new Camper("Quentin Tarantino", cooking);
        Camper c3 = new Camper("Leonardo DiCaprio", cooking);
        Camper c4 = new Camper("Bred Pitt", cooking);
        Camper c5 = new Camper("Tom Hardy", cooking);
        Camper c6 = new Camper("Captain America", cooking);
        Camper c7 = new Camper("Iron Man", cooking);
        Camper c8 = new Camper("Batman", cooking);
        Camper c9 = new Camper("CatWoman", cooking);
        Camper c10 = new Camper("Superman", cooking);
        Camper c11 = new Camper("Harley Quinn", cooking);
        Camper c12 = new Camper("Joker", cooking);
        Camper c13 = new Camper("Green Arrow", cooking);
        Camper c14 = new Camper("Deadpool", cooking);
        Camper c15 = new Camper("Venom", cooking);

        new Thread(owner).start();
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
        new Thread(c4).start();
        new Thread(c5).start();
        new Thread(c6).start();
        new Thread(c7).start();
        new Thread(c8).start();
        new Thread(c9).start();
        new Thread(c10).start();
        new Thread(c11).start();
        new Thread(c12).start();
        new Thread(c13).start();
        new Thread(c14).start();


    }
}
