package Multithreading.Locks;

import java.util.concurrent.locks.StampedLock;

class SharedResourceStampede {
	int a = 10;
	StampedLock lock = new StampedLock();

	public void producer() {
		long stamp = lock.tryOptimisticRead();
		try {
			System.out.println("Taken optimistic lock");
			a = 11;
			Thread.sleep(6000);
			if (lock.validate(stamp)) {
				System.out.println("updated a value successfully");
			} else {
				System.out.println("rollback of work");
				a = 10; // rollback
			}
		} catch (Exception e) {

		}
	}

	public void consumer() {
		long stamp = lock.writeLock();
		System.out.println("write lock acquired by :" + Thread.currentThread().getName());
		try {
			a = 9;
			System.out.println("performing work");
		} finally {
			lock.unlockWrite(stamp);
			System.out.println("write lock released by:" + Thread.currentThread().getName());
		}
	}
}

public class StampedeLockExample {

	public static void main(String[] args) {
		SharedResourceStampede sc = new SharedResourceStampede();

		Thread t1 = new Thread(() -> {
			sc.producer();
		});

		Thread t2 = new Thread(() -> {
			sc.consumer();
		});

		t1.start();
		t2.start();
	}

}
