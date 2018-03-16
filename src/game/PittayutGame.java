package game;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * Game of guessing a secret number.
 * 
 * @author Pittayut Sothanakul
 * @version 2018.01.12
 */
public class PittayutGame extends NumberGame implements Observer {
	private int secret;
	private int upperBound;
	private String message;

	/**
	 * Initialize a new game.
	 * 
	 * @param upperbound
	 *            is the max value for the secret number (>1).
	 */
	public PittayutGame(int upperBound) {
		this.upperBound = upperBound;
		this.secret = getRandomNumber(upperBound);
		// System.out.println(secret);
		this.message = "I'm thinking of a number between 1 and " + upperBound;
	}

	/**
	 * Create boolean to change Sting hint
	 * 
	 * @param number
	 *            is number form your input
	 * @return new hint if you guess true or false
	 */
	public boolean guess(int number) {

		boolean check = false;
		if (number == this.secret) {
			setMessage("Correct !! secret is " + this.secret);
			setChanged();
			notifyObservers();
			return true;
		} else {
			check = false;
			if (number > this.secret) {
				setMessage("too large");
			} else if (number < this.secret) {
				setMessage("too small");
			}
			count++;
		}
		setChanged();
		notifyObservers();
		return check;
	}

	/**
	 * Return a maximum to guess.
	 * 
	 * @return maximum to guess.
	 */
	public int getUpperBound() {
		return upperBound;
	}

	/**
	 * Return a random number to guess.
	 * 
	 * @return random number to guess.
	 */
	private int getRandomNumber(int limit) {
		long seed = System.currentTimeMillis();
		Random random = new Random(seed);
		return random.nextInt(limit) + 1;
	}

	public String toString() {
		return "Guess a secret number between 1 and " + upperBound;
	}

	@Override
	public void update(Observable subject, Object info) {
		System.out.println("Your guess");
	}

}
