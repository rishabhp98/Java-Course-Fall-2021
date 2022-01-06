import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Project12 {

	public static void main(String[] args)
		throws FileNotFoundException, IOException {

		final String FILENAME_COMMON = "common-dictionary.txt";
		final String FILENAME_PERSONAL = "personal-dictionary.txt";
		String prompt = "Enter a word or 'quit' to stop: ";

		// Read the common dictionary and store the words in an array.
		ArrayList<String> common = readFile(FILENAME_COMMON);

		// Construct an oversize array to store the personal dictionary.
		ArrayList<String> personal = readFile(FILENAME_PERSONAL);

		
		// Construct a Scanner to read user input from the keyboard.
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Spell Checker");
		System.out.println("-------------");
		
		// Perform a priming read to get the first word.
		System.out.print(prompt);
		String word = keyboard.nextLine().toLowerCase();
		
		// Enter the user input loop.
		while (!word.equals("quit")) {
			
			// Check if the word is in either dictionary.
			if (checkSpelling(common, personal, word)) {
				System.out.println("The word is spelled correctly.");
			} 
			else {
				System.out.println("The word was not found in the "
					+ "dictionary.");			
				System.out.println("Would you like to add it to your personal "
					+ "dictionary (yes/no)?");
				String response = keyboard.nextLine().toLowerCase();
				
				// If the user responds "yes" and there is room in the oversize
				// array, add the word to the end of the array and sort it.
				if (response.equals("yes")) {
					personal.add(word);
					personal.sort(null);
				}
			}
			
			// Get the next word from the user.
			System.out.println();
			System.out.print(prompt);
			word = keyboard.nextLine().toLowerCase();
		}
		
		keyboard.close();
		writeFile(FILENAME_PERSONAL, personal);
		System.out.println("Goodbye!");
	}
	
	// Read each line of a file and store them in a arrayList
	public static ArrayList<String> readFile(String filename)   // return type ArrayList
		throws FileNotFoundException {
			
		ArrayList<String> lines = new ArrayList<String>();   // create a arraylist to storage the file 
		
		// Loop through the file again, adding each line to the array.
		Scanner file = new Scanner(new File(filename));
		// add each line of the file to the arrayList
		while(file.hasNext()) lines.add(file.nextLine());
		// close input string
		file.close();

		// Return the lines of the file.
		return lines;
	}

	// Return true if word is in either array; otherwise, return false. Note 
	public static boolean checkSpelling(ArrayList<String> common, ArrayList<String> personal, String word)  
	{
			return common.contains(word) || personal.contains(word);  // return true if it is found in either of them 
	}
	
	// Write the elements of the  arrayList 
	public static void writeFile(String filename, ArrayList<String> array)
			throws FileNotFoundException {

		// instaciates the output stream
		PrintWriter writer = new PrintWriter(filename);

		// prints each element of the array into the output string 
		for (String word : array) writer.println(word);

		// Close the file; otherwise, the contents will be lost.
		writer.close();
	}
}
