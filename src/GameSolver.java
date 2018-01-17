
import java.util.Scanner;

public class GameSolver {
	/** play the game. */
	public int play(PittayutGame game) {
		Scanner console = new Scanner(System.in);

		// describe the game
		System.out.println(game.toString());

		// This is just an example.

		boolean check = false;
		int min = 1;
		int max = game.getUpperBound();
		int guess;
		int time = 0;
		System.out.println(game.getMessage());
		guess = min + (max - min) / 2;
		int divide = guess / 2;
		int newGuess = guess;

		do {
			time++;
			System.out.println("time " + time);
			System.out.print("Your answer? ");
			System.out.println(guess);
			check = game.guess(guess);
			System.out.println(game.getMessage());

			if (game.getMessage() == "too large") {
				if (guess - divide == newGuess) {
					guess++;
				}
				guess -= divide;

			} else if (game.getMessage() == "too small") {
				if (guess + divide == newGuess) {
					guess++;
				}
				guess += divide;

			}
			if (divide > 1) {
				divide = divide / 2;
			}
		} while (!check);
		System.out.println("Your count " + game.getCount() + " times");
		return guess;
	}

}
