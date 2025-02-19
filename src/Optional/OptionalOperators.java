package Optional;

import java.util.Optional;

public class OptionalOperators {
	
	public static void main(String[] args) {
		
		Optional<String> stringOpt=Optional.of("String");
		Optional<String> emptyOpt=Optional.empty();

		
		System.out.println(stringOpt.orElseThrow());
		
		//get()
		System.out.println(stringOpt.map((s)->s.length()));
		System.out.println(emptyOpt.map(s->s.length()));
		
		//filter
		System.out.println(stringOpt.filter(s->s.length()>0));
	}

}
