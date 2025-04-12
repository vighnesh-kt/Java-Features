package FunctionalProgramming;

public class PureFunctionExample {

	static int total = 0; // External state (global variable)

	// Impure function: modifies external state (total)
	static int addToTotal(int num) {
		total += num; // Side effect: modifies total
		return total;
	}

	// Pure function: No side effects, always returns the same output for the same
	// input
	static int add(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {

		// pure function
		System.out.println(add(5, 3)); // Output: 8
		System.out.println(add(5, 3)); // Output: 8 (Same input, same output)

		// impure function
		System.out.println(addToTotal(10));
		System.out.println(addToTotal(10));

	}
}
