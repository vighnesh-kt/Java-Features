package FunctionalProgrammingTechniques;

import java.util.function.Function;

public class FunctionChaining {

	public static void main(String[] args) {
		Consumer<String> c1 = s -> System.out.println(s);
		Consumer<String> c2 = s -> System.out.println(s);
//		c1.accept("Hello");
//		c2.accept("World");

		// doing chaining
		// calling c3 to execute both c1,c2 instead of calling them seperately
		Consumer<String> chain = (s) -> {
			c1.accept(s);
			c2.accept(s);
		};
		// chain.accept("HEllo");

		// Consumer<String> c4=c1.thenAccept(null);
//		c4.accept("world");

		Function<Integer, Integer> f1 = (s) -> s + 5;
		Function<Integer, Integer> f2 = (s) -> s + 5;
		Function<Integer, Integer> f3 = f1.andThen(f2);
		System.out.println(f3.apply(5));
	}

}
