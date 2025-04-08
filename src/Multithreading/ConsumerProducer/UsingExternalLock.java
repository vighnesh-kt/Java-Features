package Multithreading.ConsumerProducer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class SharedResourceExternal {
	boolean isAvailable = false;
	ReentrantLock lock = new ReentrantLock();

	Condition condition = lock.newCondition();

	public void producer() {
	    lock.lock();
	    try {
	        while (isAvailable) {
	            // Wait until consumer consumes the item
	            condition.await();
	        }
	        // Produce item
	        System.out.println("Producer produced item");
	        isAvailable = true;

	        // Notify consumer
	        condition.signalAll();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    } finally {
	        lock.unlock();
	    }
	}


	public void consumer() {
	    lock.lock();
	    try {
	        while (!isAvailable) {
	            // Wait until item is produced
	            condition.await();
	        }
	        // Consume item
	        System.out.println("Consumer consumed item");
	        isAvailable = false;

	        // Notify producer
	        condition.signalAll();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    } finally {
	        lock.unlock();
	    }
	}


}

public class UsingExternalLock {

}
