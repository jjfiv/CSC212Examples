import java.util.Random;

@SuppressWarnings("javadoc")
public class GuessingGame2 {
	private int secret;

	public GuessingGame2(int secret) {
		this.secret = secret;
	}

	public boolean guessWins(int guess) {
		return guess == this.secret;
	}

	public String messageForGuess(int guess) {
		if (guess > this.secret) {
			return "Too high!";
		} else if (guess < this.secret) {
			return "Too low!";
		} else {
			return "You've won!";
		}
	}

	public int directionOfGuess(int guess) {
		if (guess > this.secret) {
			return -1; // make it smaller next time
		} else if (guess < this.secret) {
			return +1; // make it bigger next time
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		Random rand = new Random();

		GuessingGame2 game = new GuessingGame2(rand.nextInt(100));
		int min = 0;
		int max = 100;
		int guess = 50;
		while (!game.guessWins(guess)) {
			guess = (min + max) / 2;
			int resp = game.directionOfGuess(guess);
			if (resp == 0) {
				break;
			} else if (resp == -1) {
				max = guess;
			} else {
				min = guess;
			}
			System.out.println("You guessed '" + guess + 
					"': " + game.messageForGuess(guess));
		}
		System.out.println("You got it: "+guess);
	}
}
