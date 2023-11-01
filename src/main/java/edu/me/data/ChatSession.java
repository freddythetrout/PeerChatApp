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

	public void addSendMessage(Message Message) {
		chat.add(Message);
	}

	public void addRecievedMessage(Message message) {
		chat.add(message);
	}

	public Integer getChatSize() {

		return chat.size();
	}

}
