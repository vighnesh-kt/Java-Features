package Multithreading.ThreadPoolExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class SimpleTask extends RecursiveTask<Integer> {

	int start;

	int end;

	public SimpleTask(int start, int end) {
		// TODO Auto-generated constructor stub

		this.start = start;

		this.end = end;
	}

	@Override
	protected Integer compute() {

		if (end - start <= 4) { //if task is less than of length 4
			int totalSum = 0;
			for (int i = start; i <= end; i++) {
				totalSum+=i;
			}
			return totalSum;
		}else {
			
			int mid=(start+end)/2;
			
			SimpleTask left=new SimpleTask(start, mid);
			SimpleTask right= new SimpleTask(mid+1, end);
			
			//Fork the subtasks for parallel execution; 
			left.fork();
			right.fork();
			
			
			// Combine the results of subtasks
			int leftResult = left.join();
			int rightResult = right.join();
			
			return leftResult+rightResult;
			
			
		}

	}

}

public class ForkjoinPoolExample {

	public static void main(String[] args) {

		
		ForkJoinPool pool=ForkJoinPool.commonPool();
		ForkJoinTask<Integer> submit = pool.submit(new SimpleTask(1, 100));
		
		try {
			System.out.println(submit.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
