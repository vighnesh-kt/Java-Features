package FunctionalProgramming;

import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionAsFirstClassCitizen {
	
	static int multiply(Function<Integer, Integer> fun,int num) {
		return fun.apply(num);
	}
	
	static Supplier<String> newString(){
		return () -> new String("I am from supplier function Hello String");
	}
	
	public static void main(String[] args) {
		
		MyFunctionalInterface f1=(a,b)->a+b;
		
		//assigned to a variable
		int sum=f1.add(10,10);
		System.out.println(sum);
		
		
		//passing function to a method
		Function<Integer, Integer> mult=(a)->a*10;
		int prod=multiply(mult, 50);
		System.out.println(prod);
		
		//returning a function from method
		Supplier<String> helloString=newString();
		System.out.println(helloString.get());
		
		
	}

}
