package edu.me.PCA;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

	private final static Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		logger.info("test");
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent rootNode = null;
		try {
			rootNode = FXMLLoader.load(App.class.getResource("main.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
