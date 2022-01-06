import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Project8 {

	public static void main(String[] args) throws FileNotFoundException
	{
		//Runs the method readFile to move the data to an array
		System.out.println("Enter a file name:");
		
		Scanner _input = new Scanner(System.in);
		String fileName_ = _input.next();
		String[] movieArray = readFile(fileName_);
		_input.close();
		
		//Runs the method lowercase to change all the strings to lowercase
		lowercase(movieArray);
		
		//Runs the method findMostFrequent and returns the most popular movie
		String mostPopular = findMostFrequent(movieArray);
		
		//prints the most popular movie
		System.out.println(mostPopular);
	}

	public static String[] readFile(String filename) throws FileNotFoundException
	{
		//creates our scanner variable and the int variable lines
		Scanner textReader = new Scanner(new File(filename));
				int lines = 0;
		
		//reads each line of the text file and accumulates lines
		while (textReader.hasNextLine()) {
		    lines++;
		    textReader.nextLine();
		}
		
		//creates our array and uses the variable lines to determine the size
		String[] movieArray = new String[lines];
		textReader = new Scanner(new File(filename));
		
		//moves the data from the file into our array
		for (int i = 0; i < lines; i++) {
			movieArray[i] = textReader.nextLine();
		}
		
		//closes our scanner and returns the new array
		textReader.close();
		return movieArray;
	}

	public static void lowercase(String[] movieArray)
	{
		//this is our code to change all the strings in the array into lowercase strings
		for (int i = 0; i < movieArray.length; i++) {
			String tempString = movieArray[i];
			tempString = tempString.toLowerCase();
			movieArray[i] = tempString;
		}
		
	}

	public static String findMostFrequent(String[] array)
	{
		//sorts the array
		Arrays.sort(array);
		
		//declares and initializes the variables
		String mostPopular = "";
		int count = 1;
		int max = 1;
		
		//compares each line of the array to the one before and accumulates the count if the same
		for (int i = 1; i < array.length; i++) {
			if (array[i].equals(array[i - 1])) {
				count++;
		//if the count is bigger than the max it assigns the max with the bigger count and most popular becomes the current string
				if(count > max) {
					max = count;
					mostPopular = "Most popular movie: " + array[i];
				}
			}
		//if the strings were different it resets the count for the new movie title
			else {
				count = 1;
			}
		}
		
		//returns out most popular movie
		return mostPopular;
	}
	
	
}
