package edu.me.network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.me.data.Message;

public class SenderSocketManager implements Runnable {

	private static final Logger logger = LogManager.getLogger(RecieverSocketManager.class);

	private Message message;
	private Integer port;
	private String ip;
	private ObjectOutputStream objectOutputStream;

	public SenderSocketManager(Message message, String ip, Integer port) {
		this.message = message;
		this.port = port;
		this.ip = ip;
	}

	private void createOutputStreamToSocket() {
		Socket senderSocket;
		ObjectOutputStream oos = null;
		try {
			senderSocket = new Socket(ip, port);
			oos = new ObjectOutputStream(senderSocket.getOutputStream());
		} catch (IOException e) {
			logger.error("Could not create socker or objectoutputstream", e);
			e.printStackTrace();
		}
		this.objectOutputStream = oos;
	}

	private void sendMessage() {
		try {
			if (this.objectOutputStream == null) {
				throw new IllegalStateException();
			}
		} catch (Exception e) {
			logger.error("An ObjectOutPutStream has to be created using sendMessage() before invoking this method", e);
		}

		try {
			this.objectOutputStream.writeObject(message);
		} catch (IOException e) {
			logger.error("Message could not be sent by the OutPutStream", e);
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		createOutputStreamToSocket();
		sendMessage();

	}

}
