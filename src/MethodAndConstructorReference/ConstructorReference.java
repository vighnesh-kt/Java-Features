package MethodAndConstructorReference;

import java.util.function.Function;

public class ConstructorReference {
	
	public static void main(String[] args) {
		
		Function<Runnable,Thread>fun=(r)->new Thread(r);
	}

}
