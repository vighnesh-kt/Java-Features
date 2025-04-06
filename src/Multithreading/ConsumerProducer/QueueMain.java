package Multithreading.ConsumerProducer;

import java.util.LinkedList;

public class QueueMain {

	public static void main(String[] args) {

		SharedResourceQueue qu = new SharedResourceQueue(new LinkedList<>(), 4);

		Thread producer = new Thread(() -> {
			for (int i = 0; i < 8; i++) {
				qu.addItem(i);
			}
		});

		Thread consumer = new Thread(() -> {
			for (int i = 0; i < 8; i++) {
				qu.consumeItem();
			}
		});

		producer.start();
		consumer.start();

	}

}
