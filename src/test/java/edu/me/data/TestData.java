package edu.me.data;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class TestData {

	@Test
	public void MessageCreationTest() {
		Message message = new Message("Testtext");
		System.out.println(message.getMessageText());
		System.out.println(message.getTime());
		System.out.println(message.getSender());
		fail("haha");
	}

}
