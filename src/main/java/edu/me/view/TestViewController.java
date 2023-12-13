package edu.me.view;

import edu.me.main.ChatService;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class TestViewController implements ViewController {

	public ChatService chatService;
	private SceneController sceneController;

	@FXML
	public ScrollPane scrollPane;
	GridPane gp;

	public void setChatService(ChatService chatservice) {
		this.chatService = chatservice;
		setup();
	}

	private void setup() {
		gp = new GridPane();
		scrollPane.setContent(gp);
		gp.boundsInParentProperty();
		gp.setBorder(null);

	}

	public void setSceneController(SceneController sceneController) {
		this.sceneController = sceneController;
	}

	public void add() {

		TextArea ta = new TextArea();
		ta.setText("blabla");
		gp.add(ta, 0, gp.getRowCount());
		ta.setPrefWidth(scrollPane.getWidth());
		ta.setPrefHeight(ta.USE_COMPUTED_SIZE);
		ta.setEditable(false);

	}

}
