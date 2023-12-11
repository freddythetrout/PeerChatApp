package edu.me.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.me.data.Message;
import edu.me.main.ChatServiceInterface;

public class RecieverSocketManager implements Runnable {

	private static final Logger logger = LogManager.getLogger(RecieverSocketManager.class);

	private Socket activeSocket;
	private Integer port;
	private ChatServiceInterface chatService;
	private Thread nextMessageThread;
	private ServerSocket serverSocket;

	public RecieverSocketManager(Integer port, ChatServiceInterface chatService) {
		this.port = port;
		this.chatService = chatService;
	}

	public void run() {

		try {
			serverSocket = new ServerSocket(port);

			this.chatService.setrecieverServerSocket(serverSocket);

			while (true) {
				logger.info("Reciever Socket in accept mode waiting for Messages");
				activeSocket = serverSocket.accept();

				ObjectInputStream objInputStream = new ObjectInputStream(activeSocket.getInputStream());

				Message recievedMessage = (Message) objInputStream.readObject();

				logger.info("Object recieved");
				chatService.recieveMessage(recievedMessage, activeSocket.getInetAddress().getHostAddress());
			}

		} catch (IOException e) {
			logger.error("IOException", e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Invalid object recieved", e);
			e.printStackTrace();
		}

	}

}
