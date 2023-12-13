package edu.me.view;

import edu.me.main.ChatService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MainViewController implements ViewController, MessageObserver {

	@FXML
	public TextArea message_text;
	@FXML
	public ScrollPane scrollPane;

	public ChatService chatService;
	@FXML
	public AnchorPane ap;
	private GridPane gp;
	private SceneController sceneController;

	public void initialize() {
		gp = new GridPane();
		scrollPane.setContent(gp);
		gp.boundsInParentProperty();
		gp.setBorder(null);
	}

	public void setChatService(ChatService chatservice) {
		this.chatService = chatservice;
		setMessageObesrver();
	}

	private void setMessageObesrver() {
		chatService.subscribe(this);
	}

	public void setSceneController(SceneController sceneController) {
		this.sceneController = sceneController;
	}

	public void setHost(ActionEvent event) {
		sceneController.setCurrentScene("HostView.fxml");
	}

	public void sendMessage() {
		chatService.sendMessage(message_text.getText());
		TextArea ta = newMessageHistoryElement(message_text.getText());
		ta.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		gp.add(ta, 0, gp.getRowCount());
		message_text.setText("");

	}

	private void addNewMessageToHistroy(String MessageText) {
		TextArea ta = newMessageHistoryElement(MessageText);
		ta.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gp.add(ta, 0, gp.getRowCount());
			}
		});

	}

	private TextArea newMessageHistoryElement(String message) {
		TextArea ta = new TextArea();
		ta.setText(message);
		ta.setPrefWidth(scrollPane.getWidth());
		ta.setPrefHeight(30);
		ta.setEditable(false);
		return ta;
	}

	@Override
	public void newMessageFromChatSession(String MessageText) {

		addNewMessageToHistroy(MessageText);
	}

}
