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
		
		// UseCase 2 
		// pool.submit(Runnable task, result)
		// - The second argument (`result`) is returned by Future.get().
		// - If this `result` object is modified inside the Runnable, you'll see the changes.
		// - If it's not modified inside the Runnable, it will remain unchanged.

		// Here, we are NOT modifying `l` inside the Runnable (we modify `list` instead),
		// so Future.get() will return the unchanged object `l` (which is empty).
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
		// Cleaner when you want to return something from a background task.
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
