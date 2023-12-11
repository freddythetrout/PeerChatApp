package edu.me.view;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.me.main.App;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

	private Stage primaryStage;
	private HashMap<String, Scene> sceneCollection = new HashMap<>();
	private Scene currentActiveScene = null;
	private final static Logger logger = LogManager.getLogger(App.class);

	public SceneController() {
	}

	public SceneController(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void addScene(String sceneName, Scene newScene) {
		sceneCollection.put(sceneName, newScene);
		logger.info("Scene for " + sceneName + " has been added to the sceneController");
	}

	public void removeScene(String sceneName) {
		sceneCollection.remove(sceneName);
		logger.info("Scene for " + sceneName + " has been rebmoed to the sceneController");
	}

	public void setCurrentScene(String sceneName) {
		currentActiveScene = sceneCollection.get(sceneName);
		primaryStage.setScene(currentActiveScene);
		primaryStage.show();
		logger.info("Scene  " + sceneName + " is now active");
	}

}
