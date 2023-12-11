package edu.me.PCA;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.me.view.ViewController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class App extends Application {

	private final static Logger logger = LogManager.getLogger(App.class);
	private static ChatService chatService;

	public static void main(String[] args) {
		chatService = new ChatService();
		launch();

	}

	@Override
	public void start(Stage primaryStage) {
		Parent rootNode = null;
		ViewController controller = null;

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
		fxmlLoader.setRoot(rootNode);
		try {
			rootNode = fxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		controller = fxmlLoader.getController();
		controller.setChatService(chatService);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("PeerChatApp - Host not set");
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent t) {
				chatService.stopRecieverServerSocket();
//				Platform.exit();
//				System.exit(0);
			}
		});

		primaryStage.show();

	}

}
