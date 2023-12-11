package edu.me.view;

import java.io.IOException;

import edu.me.PCA.ChatService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewController {

	@FXML
	public TextArea message_text;
	@FXML
	public TextArea message_history;
	public ChatService chatService;
	@FXML
	public AnchorPane ap;

	public void setChatService(ChatService chatservice) {
		this.chatService = chatservice;
	}

	public void setHost(ActionEvent event) {
		// System.out.println(getClass().getResource("/edu/me/PCA/setHost.fxml"));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/me/PCA/setHost.fxml"));
		Parent rootNode = null;
		fxmlLoader.setRoot(rootNode);
		try {
			rootNode = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HostController controller = fxmlLoader.getController();
		controller.setChatService(chatService);
		Scene scene = new Scene(rootNode);

		Stage stage = (Stage) ap.getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}

	public void sendMessage() {
		chatService.sendMessage(message_text.getText());
		message_history.appendText("\n" + message_text.getText());
		message_text.setText("");
	}

	private void updateMessageHistory() {
		// TODO asdkfjdsaf
	}

}
