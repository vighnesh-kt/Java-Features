package Multithreading.Deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {

	private final ReentrantLock lock1 = new ReentrantLock(); // Lock 1
	private final ReentrantLock lock2 = new ReentrantLock(); // Lock 2

	// Method 1: Locks lock1, then lock2
	public void method1() {
		synchronized (lock1) {
			System.out.println("Thread 1: Holding lock 1...");
			try {
				Thread.sleep(100); //using this to make time to hold lock
			} catch (InterruptedException e) {
			}
			System.out.println("Thread 1: Waiting for lock 2...");
			synchronized (lock2) {
				System.out.println("Thread 1: Acquired lock 2!");
			}
		}
	}
	
	
	//using timeout for locks
//	public void method1() {
//	    try {
//	        if (lock1.tryLock(1, TimeUnit.SECONDS)) {
//	            try {
//	                if (lock2.tryLock(1, TimeUnit.SECONDS)) {
//	                    try {
//	                        // work
//	                    } finally {
//	                        lock2.unlock();
//	                    }
//	                }
//	            } finally {
//	                lock1.unlock();
//	            }
//	        }
//	    } catch (InterruptedException e) {
//	        e.printStackTrace();
//	    }
//	}
	
	//deadlock monitoring
	
//	ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
//	long[] deadlockedThreads = threadBean.findDeadlockedThreads();
//	if (deadlockedThreads != null) {
//	    System.out.println("Deadlock detected!");
//	}
//

	// Method 2: Locks lock2, then lock1
	public void method2() {
		synchronized (lock2) {
			System.out.println("Thread 2: Holding lock 2...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			System.out.println("Thread 2: Waiting for lock 1...");
			synchronized (lock1) {
				System.out.println("Thread 2: Acquired lock 1!");
			}
		}
	}

	public static void main(String[] args) {
		DeadLockExample deadlockExample = new DeadLockExample();

		// Thread 1 tries to execute method1 (lock1 -> lock2)
		Thread thread1 = new Thread(deadlockExample::method1);

		// Thread 2 tries to execute method2 (lock2 -> lock1)
		Thread thread2 = new Thread(deadlockExample::method2);

		// Start both threads
		thread1.start();
		thread2.start();
		
		
		
	}
	
	
}
