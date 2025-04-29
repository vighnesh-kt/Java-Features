package Multithreading.Deadlock;

public class RaceConditionExample {

	private  int  counter;

	public void incremnt() {
		counter++;
	}

	public static void main(String[] args) {

		RaceConditionExample d = new RaceConditionExample();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				d.incremnt();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				d.incremnt();
			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();

			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(d.counter);

	}

}
