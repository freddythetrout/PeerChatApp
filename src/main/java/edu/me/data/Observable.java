package edu.me.data;

import edu.me.view.MessageObserver;

public interface Observable {

	public void subscribe(MessageObserver subscriber);

	public void unsubscribe(MessageObserver subscriber);

	public void notifySubscribers();

}
