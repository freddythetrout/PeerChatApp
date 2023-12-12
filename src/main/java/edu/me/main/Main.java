package edu.me.main;

public class Main {

	public static void main(String[] args) {
		// Could not start the app directly from JavaFXApp class from a exported jar
		// Workarround is this class.
		JavaFXApp.main(args);
	}

}
