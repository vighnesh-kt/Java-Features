package Multithreading.CompletableFuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));

		// Supply async
		CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(() -> {

			return "Task completed ";

		}, pool);

		try {
			System.out.println(cFuture.get());// get will wait for task to get completed
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// thenApply() and thenApplyAsync()

		// Supply async
		CompletableFuture<String> eg2 = CompletableFuture.supplyAsync(() -> {
			
			try {
				System.out.println("Task completed in supplyAsync"+Thread.currentThread().getName());
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Task completed in supplyAsync "+Thread.currentThread().getName();

		}, pool).thenApplyAsync((String val)->{ //uses same thread which is used in prevoius async task
			//chaining thread
			System.out.println("Used supplyAsync return string in thenApply "+Thread.currentThread().getName());
			return val+"Used supplyAsync return string in thenApply"+Thread.currentThread().getName();
		});

//		try {
//		eg2.get();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		pool.shutdown();
		
		
		//thenCompose()
	}

}
