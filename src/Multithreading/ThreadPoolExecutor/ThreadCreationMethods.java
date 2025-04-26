package Multithreading.ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCreationMethods {
	
	public static void main(String[] args) {
		
		
		ExecutorService orderLogger = Executors.newSingleThreadExecutor();
		orderLogger.submit(() -> saveOrderLog("Order Placed: #1234"));
		orderLogger.submit(() -> saveOrderLog("Order Placed: #1235"));

		
	}

}
