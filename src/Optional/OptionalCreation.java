package Optional;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalCreation {

	public static void main(String[] args) {
		String s = "hello";
		Optional<String> opt = Optional.of(s);

		// empty
		Optional<String> empty = Optional.empty();

		Optional<String> nullable = Optional.ofNullable(s);

		// this will also be empty optional
		Optional<String> emptyOptional = Optional.ofNullable(null);

		System.out.println(opt);
		System.out.println(empty.isEmpty());
		System.out.println(nullable);
		System.out.println(emptyOptional);
		// empty.get();
		// opt.get();
		// emptyOptional.get();

		// isPresent
		System.out.println(opt.isPresent() ? opt.get() : "0");

		// orElse()
		System.out.println(empty.orElse("String as Optional<String>empty is String type"));

		// orElseGet()
		Supplier<String> error = () -> "Error";
		System.out.println(empty.orElseGet(error));
		System.out.println(empty.orElseGet(() -> "Error"));
		System.out.println(empty.orElseThrow(() -> new InputMismatchException()));

	}

}
