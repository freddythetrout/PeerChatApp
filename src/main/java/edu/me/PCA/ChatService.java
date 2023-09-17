package edu.me.PCA;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.me.data.ChatSession;
import edu.me.data.Message;
import edu.me.network.RecieverSocketManager;
import edu.me.network.SenderSocketManager;

public class ChatService implements ChatServiceInterface {

	private static final Logger logger = LogManager.getLogger(ChatService.class);

	private ChatSession chatSession;
	private Thread recieverThread;
	private Integer port = 6666;

	public ChatService() {
		this.chatSession = new ChatSession();

		RecieverSocketManager recieverSocketManager = new RecieverSocketManager(port, this);
		recieverThread = new Thread(recieverSocketManager);
		recieverSocketManager.run();

		logger.info("Application startet and chat service initiated");
	}

	@Override
	public void sendMessage(String messageText) {

		Message message = new Message(messageText);
		String destinationIP = chatSession.getContact().getIpAdress();

		SenderSocketManager senderSocketManager = new SenderSocketManager(message, destinationIP, this.port);
		new Thread(senderSocketManager).run();

		chatSession.addSendMessage(message);
		// update gui

		logger.info(String.format("A string \" %s \" ", messageText));
	}

	@Override
	public void recieveMessage(Message message) {
		chatSession.addRecievedMessage(message);
		// update gui

	}

	@Override
	public void sethost(String ipAdress) {
		this.chatSession.setContactIP(ipAdress);

	}

	@Override
	public void setRecieverThread(Thread recieverThread) {
		this.recieverThread = recieverThread;
	}

}