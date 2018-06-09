import java.io.PrintWriter;
import java.util.Scanner;

public class Stupid {
	public static void main(String[] args) {
		new Thread(() -> {
			Scanner in = new Scanner(System.in);
			System.out.println(in.nextLine());
		}).start();
		
		PrintWriter out = new PrintWriter(System.out);
		out.print("dupa");
	}
}
