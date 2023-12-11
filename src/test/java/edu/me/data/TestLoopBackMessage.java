package edu.me.data;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.me.main.ChatService;

public class TestLoopBackMessage {

	ChatService cs;

	@BeforeEach
	public void setUp() {
		cs = new ChatService();

	}

	@Test
	public void SendandRecieveMessageTest() {

		cs.sethost("127.0.0.1");
		cs.sendMessage("1. message");
		cs.sendMessage("2. message");

		try {
			Thread mainThead = Thread.currentThread();
			System.out.println("wating a seccond...");
			mainThead.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue(cs.chatSession.getChatSize() == 4);

	}

}
