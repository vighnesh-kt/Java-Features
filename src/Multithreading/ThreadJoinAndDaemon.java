package Multithreading;

public class ThreadJoinAndDaemon {

	public static void main(String[] args) {

		System.out.println("Main thread start");

		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(3000);
				System.out.println("T1 thread ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			System.out.println("T2 thread ");
		});

		t1.setPriority(10);
		t1.setDaemon(true);
		t1.start();

		t2.start();

		try {
			System.out.println("Main is waiting");
//			t1.join();
			t2.join();// if make t1 as daemon jvm kills it after excetuon of user thred t1 doesnt
						// execute
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Main method end");
	}

}
