package edu.me.data;

import java.util.ArrayList;

public class ChatSession {

	private ArrayList<Message> chat = new ArrayList<Message>();
	private Contact contact = new Contact();

	public Contact getContact() {
		return contact;
	}

	public void setContactIP(String ipAdress) {
		this.contact.setIpAdress(ipAdress);
	}

	public void setContactName(String name) {
		this.contact.setContactName(name);
	}

	public void addSendMessage(String Message) {

	}

	public void addRecievedMessage(Message message) {

	}

}
