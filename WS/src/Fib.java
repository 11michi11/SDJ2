import java.util.Scanner;

public class Fib {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter int x: ");

		int x = in.nextInt();
		System.out.println("----------");

		for (int i = 1; i <= x; i++)
			System.out.println(fib(i));

		System.out.println("----------");

		int a = 1, b = 1, tmp;
		if (x >= 1)
			System.out.println(a);
		if (x >= 2)
			System.out.println(b);
		for (int i = 3; i <= x; i++) {
			tmp = b;
			b = a + b;
			a = tmp;
			System.out.println(b);

		}

	}

	public static int fib(int n) {
		if (n == 1 || n == 2)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}

}
