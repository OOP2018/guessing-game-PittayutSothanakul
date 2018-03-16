package observer;

import java.util.Observable;

import game.NumberGame;

public class ConsoleGuessView implements java.util.Observer {
	private NumberGame numberGame;

	public ConsoleGuessView(NumberGame numberGame) {
		this.numberGame = numberGame;
	}

	@Override
	public void update(Observable subject, Object info) {
		System.out.println("Count : " + numberGame.getCount());

	}

}
