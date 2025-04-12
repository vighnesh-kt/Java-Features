package Multithreading.ConsumerProducer;

public class SharedResource {

	boolean itemAvailable;

	public synchronized void addItem() {
		itemAvailable = true;
		System.out.println(
				"Item addeds by" + Thread.currentThread().getName() + "and invoking all thread which are waiting");
		notifyAll();
	}

	public synchronized void consumeItem() {
		System.out.println("Consumer method invoked by" + Thread.currentThread().getName());
		while (!itemAvailable) {
			try {
				System.out.println("Thread " + Thread.currentThread().getName() + "waiting now");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Item consumerd by " + Thread.currentThread().getName());
		itemAvailable = false;
	}

}
