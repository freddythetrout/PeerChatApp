module PeerChatApp {

	exports edu.me.main to javafx.fxml, javafx.graphics;
	exports edu.me.view to javafx.fxml;

	opens edu.me.view to javafx.fxml;

	requires javafx.base;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.controls;
	requires org.apache.logging.log4j;

}