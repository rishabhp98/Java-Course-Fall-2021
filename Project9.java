import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class Project9 {
	
	public static void main(String[] args) throws IOException

	{
		final String COMMON_DICTIONARY = "common-dictionary.txt";
		final String PERSONAL_DICTIONARY = "personal-dictionary.txt";
		
		String[] commonWords = readFilePerfect(COMMON_DICTIONARY);
		String[] personalDictionary = new String[100]; //creates an oversize array
		
		int numWordInpersonalDictionary = readFileOversize(PERSONAL_DICTIONARY, personalDictionary);
		
		System.out.println("Spell Checker");
		System.out.println("__________");
		System.out.println("Enter a word or 'quit' to stop:");
		
		Scanner input = new Scanner(System.in);
		String userWord = input.next();
		String userAnswer = "";
		boolean spelledCorrect = false;
		
		while (!userWord.equalsIgnoreCase("quit")) {
			
			userWord.toLowerCase(); //changes to lower case user input
			
			//checking spelling and assigning true or false value returned by method
			spelledCorrect = checking(commonWords, personalDictionary, userWord, numWordInpersonalDictionary);
			
			if (spelledCorrect) { //if spelling is correct
				System.out.println("The word is spelled correctly");
			} else { //is spelling is incorrect prompt the user to decide whether to add it to dictionary
				System.out.println("The word was not found in the dictionary.");
				System.out.println("Would you like to add it to your personal dictionary (yes/no)?");
				userAnswer = input.next();
				
				if(userAnswer.equalsIgnoreCase("yes")) { //is yes
					personalDictionary[numWordInpersonalDictionary] = userWord;//adds word to oversize array
					numWordInpersonalDictionary += 1;//updates size of array
				}
			}
			
			System.out.println("\n" + "Enter a word or 'quit' to stop:");			
			userWord = input.next(); //gets new input of user
		}
		
		//writing new words into personal words file and closing scanner
		writeFile(personalDictionary, numWordInpersonalDictionary, PERSONAL_DICTIONARY);
			
		input.close();
		
	}
	
	public static String[] readFilePerfect(String fileName) throws FileNotFoundException
	{
		//creates our scanner variable and the int variable lines
		Scanner dataReader = new Scanner(new File(fileName));
				int lines = 0;
		
		//reads each line of the text file and accumulates lines
				
		while (dataReader.hasNextLine()) {
		    lines++;
		    dataReader.nextLine();
		}
		
		//creates our array and uses the variable lines to determine the size
		
		String[] dictionaryArray = new String[lines];
		dataReader = new Scanner(new File(fileName));
		
		//moves the data from the file into our array
		
		for (int i = 0; i < lines; i++) {
			dictionaryArray[i] = dataReader.nextLine();
		}
		
		//closes our scanner and returns the new array
		dataReader.close();
		return dictionaryArray;
	}
	
	public static int readFileOversize( String fileName, String[] personalArray) throws FileNotFoundException, IOException
	
	{
		// create your file 
		
		File file = new File(fileName);
		file.createNewFile();
		
		// call the file using scanner
		
		Scanner lineReader = new Scanner(file);
		
		int count = 0;
		
		// reaf the file using a while loop
		
		while (lineReader.hasNextLine()) 
		{
			personalArray[count]=lineReader.nextLine();
			++count;
		}
		// close the scanner
		
		lineReader.close();
		
		// return the size of the array 
		return count;
		
	}
	
	public static boolean checking(String[] dictionary, String[] personal, String word, int size )
	
	{
		// variable to analyze if the dictionaries have the  word 
		int check;
		int check2;
		boolean checker = false;
		// search the word in the perfectsize array 
		
		check = Arrays.binarySearch(dictionary,word);
		
		if (check>=0)
		{
			
			checker=true;	
		
		}
		// search the word in the oversize array 
		
		else 
		{
			for(int i =0; i<size; ++i) 
		
			
		{  
			if (personal[i].equalsIgnoreCase(word))
			{
				checker=true;
				break;
			}
		
		}
		
		}
		 // return checker as false or true if the word is in or not
		return checker;	
	}
	
	public static void writeFile(String[] personal, int size, String fileName) throws FileNotFoundException{
		
		File fileWrite = new File(fileName);
		
		//creates writer to fill the file 
		
		PrintWriter writer = new PrintWriter(fileWrite); 
		
		for(int i = 0; i < size; ++i) 
		{                                      // add the new words to the array 
			writer.println(personal[i]);			
		}
		
		// close the variable 
		writer.close();
	}
	
	
	
	

}
