package Multithreading;

class RunnableExample implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
	}

}

public class Basics {

	public static void main(String[] args) {

		Runnable r1 = new RunnableExample();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();

		Runnable r2 = () -> {

			System.out.println(Thread.currentThread().getName());

		};
		Thread t3 = new Thread(r2);
		t3.start();

	}
}
