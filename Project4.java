import java.util.Scanner;

public class Project4 {

	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		String senseofhumor;
		String peoplesocially;
		String tiredmosttime;
		int Score = 0; //Here Score is an accumulator
		
		System.out.println("Answer yes or no to the following questions");

		//First question
		System.out.println("I am losing my sense of humor.");  
		senseofhumor = keyboard.nextLine();
		
		if (senseofhumor.equalsIgnoreCase("YES")) 
		{
			Score = Score + 1;	
		}
	
		//Second question
		System.out.println("I find it more and more difficult to see people socially."); 
		peoplesocially = keyboard.nextLine();
		
		if (peoplesocially.equalsIgnoreCase("YES"))
		{
			Score = Score + 1;
		}
		
		//Third question
		System.out.println("I feel tired most of the time."); 
		tiredmosttime = keyboard.nextLine();
		
		if (tiredmosttime.equalsIgnoreCase("YES"))
		{
			Score = Score + 1;
		}
		
		//Scoring criteria
		
		if (Score == 0) 
		{
			System.out.println("You are more exhausted than stressed out");	
		}
		else if (Score == 1)
		{
			System.out.println("You are beginning to stress out");	
		}
		else if (Score == 2)
		{
			System.out.println("You are possibly stressed out");
		}
		else if (Score == 3)
		{
			System.out.println("You are probably stressed out");
		}
		else
		{
			System.out.println("Error"); //Cascading if-else statement
		}
	}
}
