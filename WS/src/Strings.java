import java.util.Scanner;

public class Strings 
{
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String theString = in.nextLine();
		
		theString = theString.toLowerCase();
		
		int nrA = 0;
		int nrB = 0;
		int nrC = 0;
		int nrD = 0;
		
		for (int i = 0; i < theString.length(); i++)
			if (theString.charAt(i) == 'a') nrA++; else
				if (theString.charAt(i) == 'b') nrB++; else
					if (theString.charAt(i) == 'c') nrC++; else
						if (theString.charAt(i) == 'd') nrD++;
		
		//System.out.println("A: " + nrA + " B: " + nrB + " C: " + nrC + " D: " + nrD);
		System.out.printf("A: %d B: %d C: %d D: %d\n", nrA, nrB, nrC, nrD);
		System.out.printf("Probability = %.4f", (nrA + nrB + nrC + nrD) / (theString.length() * 1.0));
	}

}
