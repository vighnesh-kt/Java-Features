package Optional;

import java.util.Optional;

public class OptionalCreation {

	public static void main(String[] args) {
		String s="Hello";
		Optional<String> opt=Optional.of(s);
		
		//empty 
		Optional<String>empty=Optional.empty();
		
		
		Optional<String>nullable=Optional.ofNullable(s);
		
		//this will also be empty optional
		Optional<String>emptyOptional=Optional.ofNullable(null);
		

		
		System.out.println(empty);
		System.out.println(nullable);
		System.out.println(emptyOptional);
	}

}
