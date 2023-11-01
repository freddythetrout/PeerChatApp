package edu.me.data;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	private String messageText;
	private LocalDateTime time;
	private String sender;
	private MessageDirection direction = MessageDirection.OUT;
	private final Logger logger = LogManager.getLogger(Message.class);

	public Message(String messageText) {
		this.messageText = messageText;
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

	public void setSender(String ipAdress) {
		this.sender = ipAdress;
	}

	public void switchDirection() {
		this.direction = MessageDirection.IN;
	}

}
