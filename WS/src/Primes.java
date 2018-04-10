import java.util.Scanner;

public class Primes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter int x: ");
		int x = in.nextInt();
		
		boolean[] array = new boolean[x+1];
		
		array[0] = true;
		array[1] = true;
		for(int i = 2;i<=Math.sqrt(x);i++) {
			for(int j = i*2;j<=x;j+=i)
				array[j] = true;
		}
		
		for(int i = 2;i<=x;i++)
			if(!array[i])
				System.out.println(i);
		
	}
}
