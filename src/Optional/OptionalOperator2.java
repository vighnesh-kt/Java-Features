package Optional;

import java.util.Optional;

public class OptionalOperator2 {

	public static void main(String[] args) {

		Optional<String> opt = Optional.of("Hello");

		Optional<Integer> empty = Optional.empty();

		// ifPresent()
		opt.ifPresent(s -> System.out.println(s.substring(2)));
		System.out.println(opt.get());

//		ifPresentOrElse()

		Optional.empty().ifPresentOrElse(s -> System.out.println(s), () -> System.out.println("Changed to not empty"));

		// stream()
		opt.stream().forEach(s -> System.out.println(s));

		// or
		System.out.println(empty.or(() -> Optional.of(3)));

		// equals()
		System.out.println(opt.equals(opt));

		// hashcode()
		System.out.println(empty.hashCode());
	}
}
