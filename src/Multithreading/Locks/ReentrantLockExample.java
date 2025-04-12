package Multithreading.Locks;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
	boolean isAvailable = false;

	public void producer(ReentrantLock lock) {
		lock.lock(); // Acquire lock
		try {
			System.out.println(System.currentTimeMillis() + "✅ Lock acquired by: " + Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(4000); // Simulate work
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock(); // Always release lock
			System.out.println(System.currentTimeMillis() + "🔓 Lock released by: " + Thread.currentThread().getName());
		}
	}
}

public class ReentrantLockExample {
	public static void main(String[] args) {
		SharedResource resource1 = new SharedResource();
		SharedResource resource2 = new SharedResource();

		ReentrantLock lock = new ReentrantLock(); // ✅ Java's built-in lock

		Thread t1 = new Thread(() -> resource1.producer(lock), "Producer-1");
		Thread t2 = new Thread(() -> resource2.producer(lock), "Producer-2");

		t1.start();
		t2.start();
	}
}
