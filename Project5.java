import java.util.Scanner;

public class Project5 {
	public static void main(String[]args) {
	
	int num1 ;
	int num2;
	int num3;
	int points = 0;
	
	num1 = (int)((Math.random()*10)+1);
	num2 = (int)((Math.random()*10)+1);
	num3 = (int)((Math.random()*10)+1);
	
	System.out.println("Your spin was " + num1 + " " + num2 + " " + num3);
	
	if(num1 == 7 && num2 == 7 && num3 == 7)
		{
			points = points + 500;
		}
	else if (num1 == num2 && num2 == num3 && num3 == num1)
		{
			points = points + 50;
		}
	else if (num1 == 7 && num2 == 7 && num3 != 7|| num1 != 7 && num2 == 7 && num3 == 7 || num3 == 7 && num2 != 7 && num1 == 7)
		{
		points = points + 15;
		}
	else if (num1 == num2 && num3 != num1 || num1 == num3 && num2 != num1 || num2 == num3 && num1 != num2)
		{
		points = points + 3;	
		}
	else 
		{
		points = points - 1;
		}
	System.out.println("You earned " + points + " " + "points.");
}
}

