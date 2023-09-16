package edu.me.PCA;

import edu.me.data.Message;
import edu.me.network.RecieverSocketManager;

public class ChatService implements ChatServiceInterface {

	private Thread recieverThread;
	private Integer Port = 6666;

	public ChatService() {
		RecieverSocketManager recieverSocketManager = new RecieverSocketManager(Port, this);
		recieverThread = new Thread(recieverSocketManager);
		recieverSocketManager.run();
	}

	@Override
	public void sendMessage(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recieveMessage(Message message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sethost(String ipAdress) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRecieverThread(Thread recieverThread) {
		this.recieverThread = recieverThread;
	}

}