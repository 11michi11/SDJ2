import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	
		Semafor semafor = new Semafor();
		
		Car car1 = new Car(semafor);
		Car car2 = new Car(semafor);
		Car car3 = new Car(semafor);

		semafor.attach(car1);
		semafor.attach(car2);
		semafor.attach(car3);
		
		System.out.println("Semafor is " + semafor.getState() + "\nPress enter to change");
		in.nextLine();
		semafor.setState(Semafor.YELLOW);

		System.out.println("Semafor is " + semafor.getState() + "\nPress enter to change");
		in.nextLine();
		semafor.setState(Semafor.GREEN);

	}
}

