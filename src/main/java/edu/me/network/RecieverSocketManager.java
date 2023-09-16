package edu.me.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.me.PCA.ChatServiceInterface;
import edu.me.data.Message;

public class RecieverSocketManager implements Runnable {

	private static final Logger logger = LogManager.getLogger(RecieverSocketManager.class);

	private Socket activeSocket;
	private Integer port;
	private ChatServiceInterface chatService;
	private Thread nextMessageThread;

	public RecieverSocketManager(Integer port, ChatServiceInterface chatService) {
		this.port = port;
		this.chatService = chatService;
	}

	public void run() {

		// prepare application to recieve next message
		RecieverSocketManager recieverSocketManager = new RecieverSocketManager(port, chatService);
		nextMessageThread = new Thread(recieverSocketManager);

		ServerSocket serverSocket;
		try {

			serverSocket = new ServerSocket(port);
			logger.info("Reciever Socket in accept mode waiting for Messages");
			activeSocket = serverSocket.accept();

			// enable Application to recieve next Message
			recieverSocketManager.run();
			this.chatService.setRecieverThread(nextMessageThread);

			ObjectInputStream objInputStream = new ObjectInputStream(activeSocket.getInputStream());
			Message recievedMessage = (Message) objInputStream.readObject();
			chatService.recieveMessage(recievedMessage);

		} catch (IOException e) {
			logger.error("IOException", e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Invalid object recieved", e);
			e.printStackTrace();
		}

	}

	public void stopServer() throws IOException {
		activeSocket.close();
	}

}
