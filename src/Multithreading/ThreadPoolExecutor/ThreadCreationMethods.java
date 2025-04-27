package Multithreading.ThreadPoolExecutor;

import java.awt.Image;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadCreationMethods {
	
	public static void main(String[] args) {
		
		
		ExecutorService orderLogger = Executors.newSingleThreadExecutor();
//		orderLogger.submit(() -> saveOrderLog("Order Placed: #1234"));
//		orderLogger.submit(() -> saveOrderLog("Order Placed: #1235"));

		
		ExecutorService paymentProcessor = Executors.newFixedThreadPool(5);
//		paymentProcessor.submit(() -> processPayment("Credit Card"));
//		paymentProcessor.submit(() -> processPayment("NetBanking"));

		
		ExecutorService chatServer = Executors.newCachedThreadPool();
//		chatServer.submit(() -> handleCustomerChat("Customer #101"));
//		chatServer.submit(() -> handleCustomerChat("Customer #102"));

		
		ScheduledExecutorService reminderService = Executors.newScheduledThreadPool(2);
//		reminderService.schedule(() -> sendDeliveryReminderEmail("Order #1234"), 2, TimeUnit.DAYS);


		ExecutorService imageProcessing = Executors.newWorkStealingPool();
//		for (Image img : uploadedImages) {
//		    imageProcessing.submit(() -> compressImage(img));
//		}

	}

}
