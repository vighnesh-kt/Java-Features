package FunctionalProgrammingTechniques;

public class TailCallRecursion {

	public static int fact(int n) {
		if (n <= 1)
			return 1;
		return n * fact(n - 1);
	}

	public static int tailRecursionFact(int n, int a) {
		if (n <= 1) {
			return a;
		}
		return tailRecursionFact(n - 1, n * a);
	}

	public static void main(String[] args) {
		System.out.println(fact(4));
		System.out.println(tailRecursionFact(4, 1));
	}
}
