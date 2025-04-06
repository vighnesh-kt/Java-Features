package Multithreading;

public class MonitorLockExample {
	
	
	synchronized void task1() {
		try {
			System.out.println("inside task1");
			Thread.sleep(10000);
			System.out.println("task 1 completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void task2() {
		System.out.println("task2, but before synchronized");
		synchronized (this) {
		System.out.println("task2,");
		
		}
	}
	
	
	public void task3() {
		System.out.println("task3");
		}
	
	public static void main(String[] args) {
		MonitorLockExample m=new MonitorLockExample();
		Thread t1=new Thread(()->m.task1());
		Thread t2=new Thread(()->m.task2());
		Thread t3=new Thread(()->m.task3());
		
		t1.start();
		t2.start();
		t3.start();
	}

}
