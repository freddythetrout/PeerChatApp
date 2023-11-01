package edu.me.PCA;

import java.net.ServerSocket;

import edu.me.data.Message;

/**
 * 
 */

public interface ChatServiceInterface {

	/**
	 * Host has to be set to run this method Creates a Message of the String, adds
	 * it to a ChatSession and sends the message to a active Socket.
	 */
	public void sendMessage(String text);;

	public void sethost(String ipAdress);

	public void recieveMessage(Message message, String ipAdress);

	void setrecieverServerSocket(ServerSocket ss);

}
