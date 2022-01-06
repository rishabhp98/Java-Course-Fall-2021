import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Project10
{
	
	public static int NUM_COLS = 4;
	public final static int NUM_ROWS = 10;
	
	public static int numOfCategories = 0;

	public static void main(String[] args) throws FileNotFoundException
	{
		//TODO Store the names of the rows in an oversize array
		
		String[] rows = new String[NUM_ROWS];
		
		//TODO Store the names of the columns in a perfect size array
		
		String[] cols = {"January", "Febraury", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		//TODO Create a two dimensional array to store the data. This array is both oversize and perfect size.  
		// The columns are perfect size
		// The rows are oversize
		
		
		double [][] dataArray = new double [NUM_ROWS][cols.length]; 
		
		String fileName;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the file name:");
		fileName = keyboard.next();
		
		//TODO Call the readFile method
		
		numOfCategories = readFile(rows, dataArray, NUM_COLS, fileName);
		
		//TODO Call the performOperations method that handles most of the user interaction
		
		numOfCategories = performOperations(rows, numOfCategories, cols, dataArray, keyboard);
		
		//TODO Call the writeFile method
		writeFile(rows, numOfCategories, NUM_COLS, dataArray, fileName);
		
		keyboard.close();
	}
	
	public static int performOperations(String[] rows, int rowSize, String[] cols, double[][] data, Scanner input)
	{
		int menuChoice = getMenuChoice(input);
		
		while (menuChoice != 6)
		{
			double total = 0.0;
			if (menuChoice==1)
			{
				System.out.println("Enter the month");
				String month = input.nextLine();
				month.strip();
				//TODO Call the findMonthlyTotal method
				total = findMonthlyTotal(cols, data, rowSize, month);
				System.out.println("The total is " + total);
			}
			else if (menuChoice==2)
			{
				System.out.println("Enter the item");
				String item = input.nextLine();
				item.strip();
				//TODO Call the findItemTotal method
				total = findItemTotal(rows, rowSize, NUM_COLS, data, item);

				System.out.println("The total is " + total);
			}
			else if (menuChoice==3)  // grand total
			{
				//TODO Call the findGrandTotal method
				total = findGrandTotal(data, rowSize, NUM_COLS);
						
				System.out.printf("The total is %.2f\n", total);
			}
			else if (menuChoice==4)
			{
				System.out.println("Enter the lower amount");
				double lower = input.nextDouble();
				System.out.println("Enter the upper amount");
				double upper = input.nextDouble();
				//TODO Call the findRangeTotal method
				
				total = findRangeTotal(data, rowSize, NUM_COLS, lower, upper);

				System.out.println("The total is " + total);
			}
			else if (menuChoice == 5)
			{
				System.out.println("What is the item?");
				String item = input.nextLine();
				System.out.println("Which month?");
				String month = input.nextLine();
				System.out.println("What is the amount");
				double amount = input.nextDouble();
				input.nextLine();
				
				//TODO Call the addToData method
				//System.out.println(rowSize);
				rowSize = addToData(rows, rowSize, cols, data, item, month, amount);
				//System.out.println(rowSize);	

				
			}

			// Priming read
			menuChoice = getMenuChoice(input);
		}
		return rowSize;
	}
	
	public static int addToData(String[] rows, int rowSize, String[] cols, double[][] data, String item, String month, double amount)
	{	
		//TODO Write the body of this method
		
		int itemRow;
		for (itemRow = 0; itemRow < rowSize; itemRow++)
			if (rows[itemRow].equalsIgnoreCase(item)) break;
		
		if (itemRow == rowSize && rowSize == NUM_ROWS) return rowSize;
		if (itemRow == rowSize) rows[rowSize++] = item;
		
		int monthColumn;
		for (monthColumn = 0; monthColumn < cols.length; monthColumn++)
			if(cols[monthColumn].equalsIgnoreCase(month)) break;
		
		if (monthColumn >= NUM_COLS) {
			String temp = cols[monthColumn];
			cols[monthColumn] = cols[NUM_COLS];
			cols[NUM_COLS] = temp;
			monthColumn = NUM_COLS++;  			
		}
		
		data[itemRow][monthColumn] += amount;		
				
		return rowSize; // stub
	}
	
	public static int findLabelIndex(String[] array, int arraySize, String label)
	{
		int index;
		for (index = 0; index < arraySize; index++)
			if (array[index].equalsIgnoreCase(label)) break;
		
		if (index == arraySize) return -1;
		
		return index; // stub
	}
	
	public static double findMonthlyTotal(String[] cols, double[][]data, int rowSize, String month)
	{
		//TODO Write the body of this method
		
		int column = 0;
		
		for (column =0;column<cols.length;++column) 
		{
			if (cols[column].equalsIgnoreCase(month))
				break;
		}
		
		double sum = 0;
		
		for ( int j=0; j < rowSize; ++j) 
		{
			//System.out.println(j + ". " + data[j][column]);
			//System.out.println(data[j][column]);
			sum = sum + data[j][column];
		}
		
		return sum; // stub
	}
	
	public static double findGrandTotal(double[][]data, int rowSize, int colSize)
	{
		//TODO Write the body of this method
		 double sum =0;
		 
		 for (int i = 0; i < rowSize; ++i)
			 for ( int j = 0; j< colSize; ++j)
				 sum += data[i][j];
		 
		return sum; // stub
	}
	
	public static double findRangeTotal(double[][]data, int rowSize, int colSize, double lowerAmount, double upperAmount)
	{
		double sum = 0;
		for (int i = 0; i < rowSize; ++i)
			 for ( int j = 0; j< colSize; ++j)
				 if (data[i][j] >= lowerAmount && data[i][j] <= upperAmount) 
					 sum += data[i][j];
		return sum;	 // Stub
	}
	
	public static double findItemTotal(String[] rows, int rowSize, int colSize, double[][]data, String item)
	{
		//TODO Write the body of this method
		
		int row= 0;
		
		for (row =0;row<rowSize;++row) 
		{
			if (rows[row].equalsIgnoreCase(item))
				break;
		}
		
		double sum = 0;
		
		for ( int j=0; j < colSize; ++j) 
		{
			//System.out.println(data[j][column]);
			sum = sum + data[row][j];
		}
		
		return sum; // stub
	
	}
	
	public static int getMenuChoice(Scanner stdin)
	{
		System.out.println("Choose one of the following options:");
		System.out.println("1. Find monthly total");
		System.out.println("2. Find item total");
		System.out.println("3. Find grand total");
		System.out.println("4. Find range total");
		System.out.println("5. Add to table");
		System.out.println("6. Exit program");
		
		int choice = stdin.nextInt();
		stdin.nextLine();
		
		while (choice < 0 || choice > 6)
		{
			System.out.println("Please enter a value from 1 to 6");
			choice = stdin.nextInt();
			stdin.nextLine();
		}
		
		return choice;
	}
	
	public static int readFile(String[] rows, double[][] data, int colSize, String fileName) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(fileName));
		
		int index;
		int size = file.nextInt();
		file.nextLine(); // get rid of newline character
		
		for (index=0; index < size && file.hasNextLine() && index < rows.length; ++index)
		{
			// Each row has a header and then twelve double values to be read in
			rows[index] = file.next();
			for (int count=0; count < colSize; ++count)  // explain that test in handout
			{
				data[index][count] = file.nextDouble();
			}
			file.nextLine(); // get rid of that pesky newline
		}
		
		file.close();
		return index;
	}
	
	public static void writeFile(String[] rows, int rowSize, int colSize, double[][] data, String fileName) throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(fileName);
		
		pw.write(rowSize+"\n");
		for (int row = 0; row < rowSize; ++row)
		{
			pw.write(rows[row] + " ");
			for (int col = 0; col < colSize; ++col)
			{
				pw.write(data[row][col] + " ");
			}
			pw.write("\n");
		}
		
		pw.close();
	}
}
