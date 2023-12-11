package edu.me.view;

import edu.me.main.ChatService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HostViewController implements ViewController {

	@FXML
	public TextField Host;
	@FXML
	public AnchorPane ap;
	public ChatService chatService;
	private SceneController sceneController;

	public void setChatService(ChatService chatservice) {
		this.chatService = chatservice;

	}

	public void setSceneController(SceneController sceneController) {
		this.sceneController = sceneController;
	}

	public void setHost() {
		chatService.sethost(Host.getText());
		sceneController.setCurrentScene("MainView.fxml");

	}
}
