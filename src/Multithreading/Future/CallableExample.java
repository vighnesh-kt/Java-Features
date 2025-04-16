package Multithreading.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Ex implements Runnable {

	private List<Integer> list;

	Ex(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		list.add(300);
	}

}

public class CallableExample {

	public static void main(String[] args) {

		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
		//Use case 1 empty runnable
		Future<?> runnable = pool.submit(() -> {
			System.out.println("Hello");
		});

		try {
			Object object = runnable.get();
			System.out.println(object);// runnable return null object
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (ExecutionException e) {

			e.printStackTrace();
		}

		// UseCase2
		List<Integer> list = new ArrayList<>(); //we are modifying this list and returning same in pool.submit
		List<Integer> l = new ArrayList<>();
		
//		Usecase 2 
//		Runnable,object it will return the object which is passesed during submit
//		if the object is modified during submit it will reflect in the result also
//		Future<List<Integer>> submit = pool.submit(new Ex(list), list); //modified during submit
		Future<List<Integer>> submit = pool.submit(new Ex(list), l); //l is not modified in submit hence null
		
		
		
		try {
			List<Integer> list2 = submit.get();
			System.out.println(list);
			System.out.println(list2);
			System.out.println(l);//null
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Usecase 3 
//		simple perform and return using callable nstead of sending it in runnable
		Future<List<Integer>> submit2 = pool.submit(()->{
			List<Integer> callable=new ArrayList<>();
			callable.add(100);
			return callable;
		});
		try {
			System.out.println(submit2.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
