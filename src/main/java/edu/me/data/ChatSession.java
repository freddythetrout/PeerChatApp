package edu.me.data;

import java.util.ArrayList;

import edu.me.view.MessageObserver;

public class ChatSession implements Observable {

	private ArrayList<Message> chat = new ArrayList<>();
	private ArrayList<MessageObserver> subscribers = new ArrayList<>();
	private Contact contact = new Contact();

	public Contact getContact() {
		return contact;
	}

	public void setContactIP(String ipAdress) {
		this.contact.setIpAdress(ipAdress);
	}

	public String getContactIP() {
		return contact.getIpAdress();
	}

	public void setContactName(String name) {
		this.contact.setContactName(name);
	}

	public void addSendMessage(Message Message) {
		chat.add(Message);
	}

	public void addRecievedMessage(Message message) {
		chat.add(message);
		notifySubscribers();
	}

	public Integer getChatSize() {

		return chat.size();
	}

	@Override
	public void subscribe(MessageObserver subscriber) {
		this.subscribers.add(subscriber);
	}

	@Override
	public void unsubscribe(MessageObserver subscriber) {
		this.subscribers.remove(subscriber);
	}

	@Override
	public void notifySubscribers() {
		subscribers.forEach(subsi -> subsi.newMessageFromChatSession(chat.get(chat.size() - 1).getMessageText()));
	}

}
