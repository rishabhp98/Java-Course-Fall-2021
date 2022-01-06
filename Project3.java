import java.util.Scanner;
public class Project3 {
		public static void main(String[]args)

	{
		Scanner keyboard = new Scanner(System.in);
		
		String yarnname;
		String substitueyarnname;
		int numberofballs;
		int yardsperball;
		int substitueyardsperball;
		double Totalyarnrequired;
		int Numberofballsofsubstituteyarn;
		
		System.out.println("Enter the name of the yarn specified by your pattern."); // Read the name of yarn
		yarnname = keyboard.nextLine();
		
		System.out.println("Enter the number of balls of " + yarnname + " " + "that are required."); // Read the number of balls of yarn
		numberofballs = keyboard.nextInt();
		
		System.out.println("Enter the number of yards per ball of " + yarnname + "."); // Read the number of yards per ball
		yardsperball = keyboard.nextInt();
		
		keyboard.nextLine();
		
		System.out.println("Enter the name of the substitute yarn."); // Read the name of substitute yarn
		substitueyarnname = keyboard.nextLine();

		System.out.println("Enter the number of yards per ball of " + substitueyarnname + "."); // Read the number of yards per ball of substitute yarn
		substitueyardsperball = keyboard.nextInt();
		
		keyboard.close();
		
		Totalyarnrequired = numberofballs * yardsperball; 		//Calculation for number of balls of substitute yarn
		Numberofballsofsubstituteyarn = (int) Math.ceil(Totalyarnrequired/substitueyardsperball); // Casting to convert the double output of math.ceil to store as an int in number of balls of substitute yarn
	
		System.out.println("You should purchase " + Numberofballsofsubstituteyarn + " balls of " + substitueyarnname + " instead of " + numberofballs + " balls of " + yarnname + ".");	
	}
}
