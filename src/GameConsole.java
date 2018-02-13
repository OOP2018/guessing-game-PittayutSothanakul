import java.util.Scanner;

/**
 * Play guessing game on the console.
 */
public class GameConsole {

	/** play the game. */
	public int play(PittayutGame game) {
		Scanner console = new Scanner(System.in);

		// describe the game
		System.out.println(game.toString());

		// This is just an example.

		boolean check = false;
		int guess;

		do {
		
			System.out.println("time "+game.getCount());
			System.out.print("Your answer? ");
			guess = Integer.parseInt(console.nextLine());
			check = game.guess(guess);
			System.out.println(game.getMessage());
		

		} while (!check);
		System.out.println("Your count " + game.getCount() + " times");
		return guess;
	}

}
