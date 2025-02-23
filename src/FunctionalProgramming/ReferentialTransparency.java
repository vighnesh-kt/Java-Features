package FunctionalProgramming;

public class ReferentialTransparency {
	
	static int add(int a,int b) {
		return a+b;
	}
	
	static int multiply(int a,int b) {
		return a*b;
	}
	
	public static void main(String[] args) {
		int res=add(10,multiply(2, 2));//we can subbstitute it with any number until it return same value 
		//int res=add(10,4);
		
		System.out.println(res);
	}

}
