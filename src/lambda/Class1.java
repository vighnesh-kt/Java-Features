package lambda;

public class Class1 {

	public static void main(String[] args) {

//		//implementing thread using lambda
//		Thread t1=new Thread(()->{
//			
//		});
//		
//		Thread t2=new Thread(()->System.out.println("hi"));

//		MyFunctionalInterface m1=(a,b) -> System.out.println(a+b);
//		m1.add(10, 10);

		// printing on fly

//		onFlyBehaviour(()->System.out.println("Hello"));
//		onFlyBehaviour(()->System.out.println("Bhaloo"));

		// calculating on fly
//		int num1=30,num2=20;
//		onFlyBehaviour((a,b)->System.out.println(a+b), num1,num2);
//		onFlyBehaviour((a,b)->System.out.println(a-b), num1,num2);

		// Lambda practice

		// 1) lambda with no return type

//		MyFunctionalInterface mf=()->System.out.println("Hello");
//		mf.print();

		// 2) method with parameter and no return type

//		MyFunctionalInterface add=(a,b)->System.out.println(a+b);
//		MyFunctionalInterface sub=(a,b)->System.out.println(a-b);
//
//		add.calculate(10, 10);
//		sub.calculate(30,20);

//		3) Method with parameter and return type

//		MyFunctionalInterface size=(s)->s.length();
//		System.out.println(size.length("ABA"));

		// 4) MEthod with multiple return statement
		MyFunctionalInterface multipleStatement = (str) -> {
			System.out.println(str.length() + 1);
			return str.length();
		};

		multipleStatement.length("");

	}

	public static void onFlyBehaviour(MyFunctionalInterface mf, int a, int b) {
		// mf.calculate(a,b);
		// mf.print();
	}

}
