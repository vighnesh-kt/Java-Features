package Multithreading.ConsumerProducer;


class Consumer implements Runnable{
	
	SharedResource sc;
	
	public Consumer(SharedResource sc) {
		// TODO Auto-generated constructor stub
		this.sc=sc;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Consumer thread"+Thread.currentThread().getName());
		sc.consumeItem();
	}
	
}

public class Main {
	
	public static void main(String[] args) {
		
		SharedResource sc=new SharedResource();
		
		Thread producer= new  Thread (()->{
			System.out.println("Producer Thread"+Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sc.addItem();
		});
	
		Thread consumer=new Thread(new Consumer(sc));
		
		producer.start();
		consumer.start();
		
		System.out.println("Main method end");
		
	}

}
