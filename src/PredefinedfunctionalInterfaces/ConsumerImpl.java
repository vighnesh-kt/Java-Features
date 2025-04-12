package PredefinedfunctionalInterfaces;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerImpl {

	public static void main(String[] args) {

		List<Integer> l1 = List.of(5, 5, 5);
		Consumer<Integer> print = s -> System.out.println(s);
		printElements(l1, print);

	}

	// print elements method using consumer
	private static <T> void printElements(List<T> l1, Consumer<T> print) {
		for (T i : l1) {
			print.accept(i);
		}

	}
}
