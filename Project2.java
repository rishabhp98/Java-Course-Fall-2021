
public class Project2 {
	
	public static void main(String[]args)

	{
		String nameofb1; // b1 is book1, b2 is book2 and b3 is book3
		String nameofb2;
		String nameofb3;
		String authorofb1;
		String authorofb2;
		String authorofb3;
		double costofb1;  
		double costofb2;
		double costofb3;
		int copiesofb1;
		int copiesofb2;
		int copiesofb3;
		final double SALES_TAX_RATE;
	
		nameofb1 = "Three Sisters"; 
		nameofb2 = "Song of Solomon";
		nameofb3 = "Owls Don't Have to Mean Death";
		authorofb2 = "Toni Morrison";
		authorofb3 = "Chip Livingston";
		authorofb1 = "Bi Feiyu";
		costofb1 = 18.99;
		costofb2 = 11.99;
		costofb3 = 80.50;
		copiesofb1 = 2;
		copiesofb2 = 4;
		copiesofb3 = 1;
		SALES_TAX_RATE = 8.75;
		
		
		double pretaxtotal;
		double salestax;
		double totalordercost;
		
		pretaxtotal = (costofb1 * copiesofb1) +  (costofb2 * copiesofb2) + (costofb3 * copiesofb3); // Calculate the pre tax total, sales tax and total order cost
		salestax = (pretaxtotal * SALES_TAX_RATE)/100;
		totalordercost = pretaxtotal + salestax;
		
		System.out.println("Purchase" + " " + copiesofb1 + " " + "copies of" + " " + nameofb1 + "," + " " + authorofb1 + "." + " " + "Each copy costs $" + costofb1 + ".");      // Output 
		System.out.println("Purchase" + " " + copiesofb2 + " " + "copies of" + " " + nameofb2 + "," + " " + authorofb2 + "." + " " + "Each copy costs $" + costofb2 + ".");
		System.out.println("Purchase" + " " + copiesofb3 + " " + "copy of" + " " + nameofb3 + "," + " " + authorofb3 + "." + " " + "Each copy costs $" + String.format("%.2f", costofb3) + ".");
		System.out.println("Total before tax: $" + String.format("%.2f", pretaxtotal));
		System.out.println("Sales tax: $" + String.format("%.2f", salestax));
		System.out.println("The total cost of your order will be $" + String.format("%.2f", totalordercost));
	}
}
