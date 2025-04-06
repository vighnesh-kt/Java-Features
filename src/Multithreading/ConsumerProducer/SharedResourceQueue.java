package Multithreading.ConsumerProducer;

import java.util.Queue;

//Assignment: Implement PRODUCER CONSUMER Problem
//Question:
//Two threads, a producer and a consumer, share a common, fixed-size buffer as a queue. The producer's job is to generate data and put it into the buffer, while the consumer's job is to consume
//the data from the buffer. The problem is to make sure that the producer won't produce data if the buffer is full, and the consumer
//won't consume data if the buffer is empty.

public class SharedResourceQueue {

	Queue<Integer> sharedBuffer;
	int bufferSize;

	public SharedResourceQueue(Queue<Integer> sharedBuffer, int bufferSize) {
		// TODO Auto-generated constructor stub
		this.sharedBuffer = sharedBuffer;
		this.bufferSize = bufferSize;
	}

	public synchronized void addItem(int num) {
		while (sharedBuffer.size() == bufferSize) {
			try {
				System.out.println("Buffer is full waiting");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sharedBuffer.add(num);
		System.out.println("Produced: " + num);
		notifyAll(); // wake up waiting consumer(s)
	}

	public synchronized void consumeItem() {
		while (sharedBuffer.isEmpty()) {
			try {
				System.out.println("Buffer empty consumer  waiting now");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int item = sharedBuffer.poll();
		System.out.println(item);
        System.out.println("Consumed: " + item);
        notifyAll(); // wake up waiting producer(s)
	}

}
