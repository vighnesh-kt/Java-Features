package MethodAndConstructorReference;

import java.util.function.Function;

public class ConstructorReference {
	
	public static void main(String[] args) {
		
		//using lamdba
		//use shortcut cmd+1 to get reference to where use method reference instead of lambda
//		Function<Runnable,Thread>threadGenerator=r->new Thread(r);
		
		
		//using constructor reference
		Function<Runnable, Thread>threadGenerator2=Thread :: new;
		
		Runnable task1=()->System.out.println("Task1");
		Runnable task2=()->System.out.println("Task2");
		Thread t1=threadGenerator2.apply(task1);
		Thread t2=threadGenerator2.apply(task2);
		
		t1.start();
		t2.start();
		
		//more compact way
		threadGenerator2.apply(t2).start();
	}

}
