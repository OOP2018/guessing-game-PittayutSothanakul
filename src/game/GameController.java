package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Class Controller UI
 * 
 * @author Pittayut Sothanakul
 *
 */
public class GameController {

	private PittayutGame pittayut;

	public void setGame(PittayutGame pittayutGame) {
		this.pittayut = pittayutGame;
	}

	@FXML
	TextField textField;
	@FXML
	Text textGuess;
	static int checkGuess;

	public void handleGuess(ActionEvent event) {
		String text = textField.getText().trim();
		try {
			int guess = Integer.parseInt(text);
			checkGuess = guess;
			pittayut.guess(guess);
			textGuess.setText(pittayut.getMessage());
			System.out.println("You guess : " + guess);
			textField.setStyle("-fx-text-box-border: blue;");

		} catch (NumberFormatException e) {
			textField.setText("");
			textField.setStyle("-fx-text-box-border: red;");
			textField.setText("");

		}
	}

	public static int getGuess() {
		return checkGuess;
	}
}
