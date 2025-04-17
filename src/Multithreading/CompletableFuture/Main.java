package Multithreading.CompletableFuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) {
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));

		CompletableFuture<String> cFuture=CompletableFuture.supplyAsync(()->{
			
			return "Task completed ";

		},pool);
		
		try {
			System.out.println(cFuture.get());//get will wait for task to get completed
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
