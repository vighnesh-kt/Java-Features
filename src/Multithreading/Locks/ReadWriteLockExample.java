package Multithreading.Locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedResourceReadWrite {
	boolean isAvailable = false;

	public void producer(ReadWriteLock lock) {
		lock.readLock().lock(); // Producer should acquire WRITE lock
		try {
			System.out.println("✅ Read Lock acquired by: " + Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(8000); // Simulate some work
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
			System.out.println("🔓 Read Lock released by: " + Thread.currentThread().getName());
		}
	}

	public void consume(ReadWriteLock lock) {
		lock.writeLock().lock(); // Consumer just reads, so READ lock is enough
		try {
			System.out.println("🔍 Write Lock acquired by: " + Thread.currentThread().getName());
			isAvailable = false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
			System.out.println("📤 Write Lock released by: " + Thread.currentThread().getName());
		}
	}
}

public class ReadWriteLockExample {

	public static void main(String[] args) {

		SharedResourceReadWrite sc = new SharedResourceReadWrite();
		SharedResourceReadWrite sc2 = new SharedResourceReadWrite();

		ReadWriteLock lock = new ReentrantReadWriteLock();

		Thread t1 = new Thread(() -> {
			sc.producer(lock);
		});

		Thread t2 = new Thread(() -> {
			sc.producer(lock);
		});

		Thread t3 = new Thread(() -> {
			sc.consume(lock);
		});

		t1.start();
		t2.start();
		t3.start();

	}
}
