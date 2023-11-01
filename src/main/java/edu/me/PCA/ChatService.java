package edu.me.PCA;

import java.io.IOException;
import java.net.ServerSocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.me.data.ChatSession;
import edu.me.data.Message;
import edu.me.network.RecieverSocketManager;
import edu.me.network.SenderSocketManager;

public class ChatService implements ChatServiceInterface {

	private static final Logger logger = LogManager.getLogger(ChatService.class);

	public ChatSession chatSession;
	private ServerSocket recieverServerSocket;
	private Integer port = 6666;

	public ChatService() {
		this.chatSession = new ChatSession();

		RecieverSocketManager recieverSocketManager = new RecieverSocketManager(port, this);
		Thread recieverThread = new Thread(recieverSocketManager);
		recieverThread.start();

		logger.info("Application startet and chat service initiated");
	}

	@Override
	public void sendMessage(String messageText) {

		Message message = new Message(messageText);
		String destinationIP = chatSession.getContact().getIpAdress();

		logger.info("Try to send message");
		SenderSocketManager senderSocketManager = new SenderSocketManager(message, destinationIP, this.port);
		new Thread(senderSocketManager).start();

		chatSession.addSendMessage(message);

		// update gui

		logger.info(String.format("Message sent:  \" %s \" ", messageText));
	}

	@Override
	public void recieveMessage(Message message, String ipAdress) {
		message.switchDirection();
		message.setSender(ipAdress);

		logger.info(String.format("Message recieved:  \" %s \" ", message.getMessageText()));

		chatSession.addRecievedMessage(message);
		// update gui

	}

	@Override
	public void sethost(String ipAdress) {
		this.chatSession.setContactIP(ipAdress);
		logger.info(String.format("Host set:  \" %s \" ", ipAdress));

	}

	@Override
	public void setrecieverServerSocket(ServerSocket ss) {
		this.recieverServerSocket = ss;
	}

	public void stopRecieverServerSocket() {
		try {
			this.recieverServerSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}