
public class DiamondLover 
{
	public static void main(String[] args)
	{
		int size = 1;
		
		System.out.println("*\n");
		
		for (int i = 2; i < 10; i++) {
			
			size += 2;
			
			for (int j = 1; j <= i; j++) {
				
				for (int k = 1; k <= size - (2 * j - 1) / 2; k++)
					System.out.print(" ");
				
				for (int k = 1; k <= 2 * j - 1; k++)
					System.out.print("*");
				
				System.out.println();
				
			}
			
			for (int j = i - 1; j >= 1; j--) {
				
				for (int k = 1; k <= size - (2 * j - 1) / 2; k++)
					System.out.print(" ");
				
				for (int k = 1; k <= 2 * j - 1; k++)
					System.out.print("*");
				
				System.out.println();
				
			}
			
			System.out.println();
			
			
		}
	}
 
}
