package edu.me.view;

import java.io.IOException;

import edu.me.PCA.ChatService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HostController {

	@FXML
	public TextField Host;
	@FXML
	public AnchorPane ap;
	public ChatService chatService;

	public void setChatService(ChatService chatservice) {
		this.chatService = chatservice;
	}

	public void setHost() {
		chatService.sethost(Host.getText());

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/me/PCA/main.fxml"));
		Parent rootNode = null;
		fxmlLoader.setRoot(rootNode);
		try {
			rootNode = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ViewController controller = fxmlLoader.getController();
		controller.setChatService(chatService);
		Scene scene = new Scene(rootNode);

		Stage stage = (Stage) ap.getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("PeerChatApp - [" + chatService.getHost() + "]");
		stage.show();

	}
}
