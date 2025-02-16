package PredefinedfunctionalInterfaces;

import java.util.function.BiFunction;

public class BiFunctionImpl {

	public static void main(String[] args) {

		// concat 2 String
		String a = "AAA";
		String b = "BBB";
		BiFunction<String, String, String> concat = (s1, s2) -> s1.concat(s2);
		System.out.println(concat.apply(a, b));

		// length of concated String
		BiFunction<String, String, Integer> concatSum = (s1, s2) -> s1.concat(s2).length();
		System.out.println(concatSum.apply("AAA", "BBB"));

	}

}
