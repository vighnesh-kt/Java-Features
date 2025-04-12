package FunctionalProgrammingTechniques;

import java.util.function.Function;

public class Currying {

	public static void main(String[] args) {
		Function<Integer, Function<Integer, Integer>> fun = i -> v -> i + v;

		// Partial application: Fixing i = 5
		Function<Integer, Integer> add5 = fun.apply(5);

		System.out.println(add5.apply(3)); // Output: 8
		System.out.println(add5.apply(10)); // Output: 15

		// Direct execution
		System.out.println(fun.apply(2).apply(7)); // Output: 9

		Function<Integer, Function<Integer, Function<Integer, Integer>>> cube = u -> v -> w -> u * v * w;

		System.out.println(cube.apply(3).apply(3).apply(3));

	}

}
