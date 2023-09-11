module PCA {

	exports edu.me.PCA;

	requires javafx.base;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.controls;
	requires org.apache.logging.log4j;

	opens edu.me.PCA to javafx.fxml;

}