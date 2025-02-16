package PredefinedfunctionalInterfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorImpl {

	public static void main(String[] args) {
		BinaryOperator<String> concat=(a,b)->a+" and "+b;
		System.out.println(concat.apply("Java", "React"));
	}

}
