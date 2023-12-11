module PeerChatApp {

	exports edu.me.main;
	exports edu.me.view;

	requires javafx.base;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.controls;
	requires org.apache.logging.log4j;

	opens edu.me.main to javafx.fxml;
	opens edu.me.view to javafx.fmxl;

}