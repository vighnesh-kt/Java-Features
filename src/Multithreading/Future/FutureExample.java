package Multithreading.Future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureExample {

	public static void main(String[] args) {
		
		ThreadPoolExecutor ex=new ThreadPoolExecutor(1, 2, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(4));
		
		Future<?> submit = ex.submit(()->{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello");
		});
		System.out.println(submit.isDone());
		try {
			submit.get(2, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
		
		 submit.get();//wait unitl the task is completed fully main will stop will not go forward until task completed
		}catch (Exception e) {
			e.printStackTrace();
		}

		
		System.out.println("is Done: " + submit.isDone());
		System.out.println("is Cancelled: " + submit.isCancelled());
		
		
	}

}
