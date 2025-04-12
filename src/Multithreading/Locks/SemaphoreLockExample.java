package Multithreading.Locks;

import java.util.concurrent.Semaphore;

class SharedResourceSemaphore {

	boolean isAvailable = false;

	public void run(Semaphore lock) {
		try {
			lock.acquire();
			System.out.println("Thread running" + Thread.currentThread().getName());
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.release();
			System.out.println("Thread released" + Thread.currentThread().getName());
		}
	}

}

public class SemaphoreLockExample {

	public static void main(String[] args) {

		SharedResourceSemaphore sc = new SharedResourceSemaphore();

		Semaphore lock = new Semaphore(1);

		Thread t1 = new Thread(() -> {
			sc.run(lock);
		});

		Thread t2 = new Thread(() -> {
			sc.run(lock);
		});
		Thread t3 = new Thread(() -> {
			sc.run(lock);
		});

		Thread t4 = new Thread(() -> {
			sc.run(lock);
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
