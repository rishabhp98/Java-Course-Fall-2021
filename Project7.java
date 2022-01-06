import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project7 
{
	public static void main(String[] args) throws FileNotFoundException
	{

		Scanner keyboard = new Scanner(System.in);
	
		String continuePlaying = "yes";

		int score = 0;
		int pointsPossible = 0;
		
		System.out.println("Welcome to Java Word Scramble!");
		System.out.println("------------------------------");
		
		while (continuePlaying.equalsIgnoreCase("yes"))
		{
			System.out.println();
			
			//42
			String word = chooseRandomWord();
			//64
			
			//66
			String scrambledWord =  returnScrambledWord(word); 
			//83
			
			//85
			int numGuesses = returnNumberOfGuesses(word, scrambledWord);
			//107
			
			int wordPoints = word.length() - 1;
			int pointsEarned = word.length() - numGuesses;
			 
			//114
			printToConsole(pointsEarned, word, wordPoints);		
			//124
			
			score += pointsEarned;
			pointsPossible += wordPoints;
			
			System.out.println("Score: " + score);
			System.out.println("Max possible points: " + pointsPossible);
		
			System.out.println("Do you want to play again (yes/no)?");
			continuePlaying = keyboard.nextLine();
		}
		
		System.out.println("Thanks for playing!");
		
		keyboard.close();
	}

public static String chooseRandomWord() throws FileNotFoundException
{
	Scanner dictionary = new Scanner(new File("dictionary.txt")); 

	int numWords = dictionary.nextInt();
	dictionary.nextLine();

	int numSkip = (int) (Math.random() * numWords);

	for (int i = 0; i < numSkip; ++i)
	{
		dictionary.nextLine();
	}
	String word = dictionary.nextLine();
	dictionary.close();
	
	return word;
}

public static String returnScrambledWord(String wordfromdic)
{
	StringBuilder tempWord = new StringBuilder(wordfromdic);
	StringBuilder scrambledTempWord = new StringBuilder();
	
	while (tempWord.length() > 0)
	{
		int letterIndex = (int) (Math.random() * tempWord.length());
		char letter = tempWord.charAt(letterIndex);
		tempWord.deleteCharAt(letterIndex);
		scrambledTempWord.append(letter);
	}
	String scrambledWord = scrambledTempWord.toString();
	
	return scrambledWord;
}

public static int returnNumberOfGuesses(String wordfromdic, String scrambledWord)
{
	Scanner keyboard = new Scanner(System.in);
	int numGuesses; 
	for (numGuesses = 1; numGuesses <= wordfromdic.length() - 1; ++numGuesses)
	{
		System.out.println("Scrambled word: " + scrambledWord);
		
		if (numGuesses > 1) {
			System.out.println("          Hint: " + wordfromdic.substring(0, numGuesses - 1));
		}
			System.out.println("What is your guess? (" + (wordfromdic.length() - numGuesses) + " guesses left)");
		
			String guess = keyboard.nextLine();
			if (guess.equalsIgnoreCase(wordfromdic)) {
			break;
		}	
	}	
	return numGuesses;
}

public static void printToConsole(int pointsEarned, String wordfromdic, int wordPoints)
{
	if (pointsEarned == 0) {  
		System.out.println("Sorry, the scrambled word was \"" + wordfromdic + "\".");
	}
	else {
		System.out.println("Congratulations! You earned " + pointsEarned + " out of " + wordPoints + " possible points.");
	}
}
}

	
