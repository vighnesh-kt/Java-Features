package Multithreading.ConsumerProducer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class SharedResourceExternal {
	boolean isAvailable = false;
	ReentrantLock lock = new ReentrantLock();

	Condition condition = lock.newCondition();

	public void producer() {
		try {
			lock.lock();

			while (isAvailable) {
				System.out.println("thread notifying");
				condition.signalAll();
			}
			isAvailable = true;
			condition.await();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			lock.unlock();
		}
	}

	public void consumer() {
		try {
			lock.lock();
			while(isAvailable) {
				System.out.println("thread changed value");
				isAvailable=false;
				condition.signalAll();
			}
			condition.await();
		}
		catch(Exception e) {
			
		}
		finally {
			lock.unlock();
		}
	}

}

public class UsingExternalLock {

}
