package game;

import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import observer.ConsoleGuessView;
import observer.CountGuessView;
import observer.YouGuessView;

/**
 * A main class for the GuessingGame. It is responsible for creating objects,
 * connecting objects, and running the game UI.
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		int upperBound = 100;
		PittayutGame pittayutGame = new PittayutGame(upperBound);
		try {
			URL url = getClass().getResource("GameUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GameUI.fxml");
				Platform.exit();
			}
			// Load the FXML and get reference to the loader
			FXMLLoader loader = new FXMLLoader(url);
			// Create the UI. This will instantiate the controller object, too.
			Parent root = loader.load();
			// Now we can get the controller object from the FXMLloader.
			// This is interesting -- we don't need to use a cast!
			GameController controller = loader.getController();

			// Dependency Injection:
			// Set the Counter object we want the view to update.

			// TODO set a reference to Counter in the controller

			controller.setGame(pittayutGame);

			// Build and show the scene
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Guessing Game");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		ConsoleGuessView consoleGuessView = new ConsoleGuessView(pittayutGame);
		pittayutGame.addObserver(consoleGuessView);
		CountGuessView countGuessView = new CountGuessView(pittayutGame);
		pittayutGame.addObserver(countGuessView);
		YouGuessView youGuessView = new YouGuessView(pittayutGame);
		pittayutGame.addObserver(youGuessView);
		countGuessView.run();
		youGuessView.run();
	}

	public static void main(String[] args) {
		launch(args);
	}

	// public static void main(String[] args) {
	//
	// // upper limit for secret number in guessing game
	// int upperBound = 10;
	//
	// PittayutGame game = new PittayutGame(upperBound);
	// // GameConsole ui = new GameConsole();
	// GameConsole ui = new GameConsole();
	// int solution = ui.play(game);
	// System.out.println("play() returned " + solution);
	// System.out.println("Your count " + game.getCount() + " times");
	//
	// }
}
