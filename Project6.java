import java.util.Scanner;

public class Project6 {
	
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		final int SENTINEL = -1; //Sentinel value in a constant variable
		int initalvalue = 3; //Initial dial value
		int count = 0;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		
		System.out.println("Response Dial Simulator");
		System.out.println("-----------------------");
		System.out.println("Initial setting: " + initalvalue); //Priming read
		System.out.println("Enter the next setting (1-5) or -1 to stop.");
		count = keyboard.nextInt();
		
		while(count != SENTINEL) //Sentinel controlled while loop
		{
			
			if(count > initalvalue) //Conditional statements to see the setting change in the dial
				{
				System.out.println("Positive change: " + initalvalue + " to " + count);
				num1 = num1 + 1;
				if (count == 1) 
					count1 = count1 + 1;
				else if (count == 2)
					count2 = count2 + 1;
				else if (count == 3)
					count3 = count3 + 1;
				else if (count == 4)
					count4 = count4 + 1;
				else if (count == 5)
					count5 = count5 + 1;
				}
				
			else if (count < initalvalue)
			{
				System.out.println("Negative change: " + initalvalue + " to " + count);
				num2 = num2 + 1;
				if (count == 1)
					count1 = count1 + 1;
				else if (count == 2)
					count2 = count2 + 1;
				else if (count == 3)
					count3 = count3 + 1;
				else if (count == 4)
					count4 = count4 + 1;
				else if (count == 5)
					count5 = count5 + 1;
			}
			else if (count == initalvalue)
			{
				System.out.println("No change: " + initalvalue + " to " + count);
				num3 = num3 + 1;
				if (count == 1)
					count1 = count1 + 1;
				else if (count == 2)
					count2 = count2 + 1;
				else if (count == 3)
					count3 = count3 + 1;
				else if (count == 4)
					count4 = count4 + 1;
				else if (count == 5)
					count5 = count5 + 1;
			}
				
			initalvalue = count;
			
			System.out.println("Current setting: " + initalvalue); //Priming read
			System.out.println("Enter the next setting (1-5) or -1 to stop.");
			count = keyboard.nextInt();
			
		}
		
		keyboard.close();
		
		System.out.print("\n");
		System.out.println("Response Summary");
		System.out.println("----------------");
		System.out.println("1 was chosen " + count1 + " time(s).");
		System.out.println("2 was chosen " + count2 + " time(s).");
		System.out.println("3 was chosen " + count3 + " time(s).");
		System.out.println("4 was chosen " + count4 + " time(s).");
		System.out.println("5 was chosen " + count5 + " time(s).");
		System.out.print("\n");
		System.out.println("Positive changes: " + num1);
		System.out.println("Negative changes: " + num2);
		System.out.println("No changes: " + num3);
		
	}
}