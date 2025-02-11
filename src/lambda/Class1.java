package lambda;


public class Class1{
	
	public static void main(String[] args) {
		
//		//implementing thread using lambda
//		Thread t1=new Thread(()->{
//			
//		});
//		
//		Thread t2=new Thread(()->System.out.println("hi"));
		
//		MyFunctionalInterface m1=(a,b) -> System.out.println(a+b);
//		m1.add(10, 10);
		
		//printing on fly
		
//		onFlyBehaviour(()->System.out.println("Hello"));
//		onFlyBehaviour(()->System.out.println("Bhaloo"));
		
		//calculating on fly
//		int num1=30,num2=20;
//		onFlyBehaviour((a,b)->System.out.println(a+b), num1,num2);
//		onFlyBehaviour((a,b)->System.out.println(a-b), num1,num2);
	
		
	}
	
	public static void onFlyBehaviour(MyFunctionalInterface mf,int a,int b) {
		mf.calculate(a,b);
		//mf.print();
	}


}

