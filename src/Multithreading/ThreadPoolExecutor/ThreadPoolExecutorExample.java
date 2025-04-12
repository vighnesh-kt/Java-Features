package Multithreading.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorExample {
	
	private static final String THREAD_NAME_PREFIX = "custom-thread-";
	
//	Used static because
//	Shared across all threads and the entire class.
//	If you create multiple thread factories or thread pools in this class, they all share the same counter.
//	Thread names will be globally unique like:
	private final static AtomicInteger count = new AtomicInteger(1);

	
	public static void main(String[] args) {
		
		ThreadFactory functionalTHread=(Runnable r)->{
			// this will perform whatever the runnable task given to the new thread
			Thread t = new Thread(r);
			t.setPriority(Thread.NORM_PRIORITY);
			t.setDaemon(false);
			
			//giving custom name using atomic integer
			t.setName(THREAD_NAME_PREFIX + count.getAndIncrement());
			return t;
		};

		ExecutorService executor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
				new CustomThreadFactory(), new CustomRejectedHandler());
		
		for(int i=1;i<=7;i++) {
			
			//submit method takes runnable
			executor.submit(()->{
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Task "+Thread.currentThread().getName());
			});
		}
		executor.shutdown();

	};

}

class CustomThreadFactory implements ThreadFactory {


	private static final String THREAD_NAME_PREFIX = "custom-thread-";
	
//	When not to use static in CustomThreadFactory
//	If each ThreadFactory is meant to be independent — like for different modules (e.g., email-thread-1, payment-thread-1) — you don’t want a shared counter.
//	Using static in that case will mix all the counts together.
	
//	ie gonna use Custom thread factory in different places
	//each will have its own count
//	new CustomThreadFactory("email")
//	new CustomThreadFactory("payment")
	private final AtomicInteger count = new AtomicInteger(1);//give accourate count but not timely accurate as 2 before 1
	@Override
	public Thread newThread(Runnable r) {

		// this will perform whatever the runnable task given to the new thread
		Thread t = new Thread(r);
		t.setPriority(Thread.NORM_PRIORITY);
		t.setDaemon(false);
		
		//giving custom name using atomic integer
//		t.setName(THREAD_NAME_PREFIX + count.getAndIncrement());
		
//		if you want jvm internal counter
		String jvmCounterString=t.getName();
		t.setName(THREAD_NAME_PREFIX+" "+jvmCounterString);
		return t;
	}

}
class CustomRejectedHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
		//logging
		System.out.println("Task denied:" + r.toString());
	}
	
}