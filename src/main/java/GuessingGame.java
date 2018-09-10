import java.util.Random;
import java.util.Scanner;

// We discussed academic honesty, so when you re-type this code, be sure to cite it in a comment!
public class GuessingGame {

	/**
	 * A Java program will run code in a special ``main`` method.
	 * Note that Java has two types of comments: block (slash-star ... star-slash), and line ("slash-slash") comments.
	 * For now we ignore args, which is an array of strings that the user might have passed in.
	 * @param args command line arguments.
	 */
	public static void main(String[] args) {
		// Configure how hard the game is by changing LOW and HIGH.
		final int HIGH = 100;
		final int LOW = 0;
		
		// Create a random number generator:
		Random rand = new Random();
		
		// Select a secret number.
		final int secretNumber = rand.nextInt(HIGH-LOW) + LOW;
		System.out.println("Welcome to the Guessing Game.");
		System.out.println("I have selected a number from ["+LOW+","+HIGH+").");
		
		// Set the current guess to something that can't be correct.
		int guess = LOW - 1;

		// We use a Scanner to turn characters from System.in into numbers.
		Scanner scanner = new Scanner(System.in);

		while(guess != secretNumber) {
			System.out.println("What is your guess? ");
			try {
				guess = scanner.nextInt();
			} catch (Exception err) {
				String whatYouSaid = scanner.nextLine().trim();
				System.out.println("Please enter a valid number! You said '" + 
						   whatYouSaid + "' but I don't understand.");
				// Continue takes us around the loop again.
				continue;
			}
			
			// Give the player a hint!
			if (guess > secretNumber) {
				System.out.println("Your guess of " + guess + " is too high.");
			} else if (guess < secretNumber) {
				System.out.println("Your guess of " + guess + " is too low.");
			}
		}
		
		// The only way we exit the loop is if we have won.
		System.out.println("Congratulations, you've won!");
		System.out.println("Thanks for playing!");
		
		// Always close resources that you open (We'll talk more about this later).
		scanner.close();
	}
}
