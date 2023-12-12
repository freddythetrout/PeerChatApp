package edu.me.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.me.view.SceneController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXApp extends Application {

	private final static Logger logger = LogManager.getLogger(JavaFXApp.class);

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) {

		SceneController sceneController = new SceneController(primaryStage);
		SceneBuilder sceneBuilder = new SceneBuilder(primaryStage, sceneController);
		Scene tempScene;

		tempScene = sceneBuilder.buildScene("HostView.fxml");
		sceneController.addScene("HostView.fxml", tempScene);

		tempScene = sceneBuilder.buildScene("MainView.fxml");
		sceneController.addScene("MainView.fxml", tempScene);
		sceneController.setCurrentScene("MainView.fxml");

		logger.info("App setup ready");
	}

}