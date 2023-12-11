package edu.me.view;

import edu.me.main.ChatService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class MainViewController implements ViewController, MessageObserver {

	@FXML
	public TextArea message_text;
	@FXML
	public TextArea message_history;
	public ChatService chatService;
	@FXML
	public AnchorPane ap;
	private SceneController sceneController;

	public void setChatService(ChatService chatservice) {
		this.chatService = chatservice;
		setMessageObesrver();
	}

	private void setMessageObesrver() {
		chatService.chatSession.subscribe(this);
	}

	public void setSceneController(SceneController sceneController) {
		this.sceneController = sceneController;
	}

	public void setHost(ActionEvent event) {
		sceneController.setCurrentScene("HostView.fxml");
	}

	public void sendMessage() {
		chatService.sendMessage(message_text.getText());
		message_history.appendText("\n" + message_text.getText());
		message_text.setText("");
	}

	private void addNewMessageToHistroy(String MessageText) {
		message_history.appendText("\n" + MessageText);
	}

	@Override
	public void newMessageFromChatSession(String MessageText) {
		addNewMessageToHistroy(MessageText);
	}

}
