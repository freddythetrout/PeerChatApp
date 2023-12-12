package edu.me.main;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.me.view.SceneController;
import edu.me.view.ViewController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SceneBuilder {

	Stage primaryStage;
	SceneController sceneController;
	ChatService chatService = new ChatService();
	private final static Logger logger = LogManager.getLogger(JavaFXApp.class);

	public SceneBuilder(Stage primaryStage, SceneController sceneController) {
		this.primaryStage = primaryStage;
		this.sceneController = sceneController;

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent t) {
				chatService.stopRecieverServerSocket();
//				Platform.exit();
//				System.exit(0);
			}
		});

		logger.info("SceneBuilder is created");
	}

	public Scene buildScene(String fxmlName) {

		AnchorPane pane = null;
		ViewController viewController = null;
		FXMLLoader fxmlLoader = null;

		try {
			fxmlLoader = new FXMLLoader(getClass().getResource(fxmlName));
			pane = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		viewController = fxmlLoader.getController();
		viewController.setChatService(chatService);
		viewController.setSceneController(sceneController);
		logger.info("Scene " + fxmlName + " is created");
		return new Scene(pane);

	}

}
