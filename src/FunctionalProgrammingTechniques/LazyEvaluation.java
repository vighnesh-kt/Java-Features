package FunctionalProgrammingTechniques;

import java.util.function.Supplier;

public class LazyEvaluation {

	public static void main(String[] args) {
		int result = compute(10); // Computed immediately
		System.out.println("Result: " + result);

		Supplier<Integer> lazyCompute = () -> compute(10);
		System.out.println(lazyCompute.get());
	}

	public static int compute(int x) {
		System.out.println("Computing...");
		return x * 2;
	}
}
