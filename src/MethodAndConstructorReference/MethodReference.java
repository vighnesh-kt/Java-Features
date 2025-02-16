package MethodAndConstructorReference;

import java.util.List;

public class MethodReference {
	
	public void greet(String s) {
		System.out.println("Hello "+s);
	}
	public static void bye(String s) {
		System.out.println("Bye "+s);
	}
	
	public static void main(String[] args) {
		MethodReference s=new MethodReference();
		List<String>ls=List.of("Raj","Jay");
		
		//non static calling by object referenece
		ls.forEach(s::greet);
		
		//static calling by class name
		ls.forEach(MethodReference::bye);
	}

}
