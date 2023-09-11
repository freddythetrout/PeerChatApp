package edu.me.data;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Message {

	private String messageText;
	private LocalDateTime time;
	private String sender;
	private final  Logger logger = LogManager.getLogger(Message.class);

	public Message(String messageText) {
		this.messageText = messageText;
		try {
			this.sender = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			logger.error("Could not recieve IP Adress of the message creator", e);
		}
		this.time = LocalDateTime.now();
	}

	public String getMessageText() {
		return messageText;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public String getSender() {
		return sender;
	}

}
