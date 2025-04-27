package Multithreading.ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class WorkStealingPoolExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        // Create WorkStealingPool (a special thread pool that supports work-stealing)
        ExecutorService pool = Executors.newWorkStealingPool();
        
        // Use a simple task that will be parallelized
        Callable<Integer> task = () -> {
            int totalSum = 0;
            for (int i = 1; i <= 100; i++) {
                totalSum += i;
                Thread.sleep(10); // simulate work
            }
            return totalSum;
        };
        
        // Submit multiple tasks to the pool
        // WorkStealingPool will distribute these tasks automatically
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(pool.submit(task));
        }

        // Get the results of all tasks
        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get(); // get() will block until the task is completed
        }
        
        System.out.println("Total Sum: " + totalSum);
        
        // Shutdown the pool
        pool.shutdown();
    }
}
