package FunctionalProgramming.HigherOrderFunction;

public class HigherOrderFunction {

	public static void main(String[] args) {

		IFactory<Integer> factory = createFactory(() -> Math.random() * 10, (r) -> r.intValue());
		System.out.println(factory.create());

	}

	public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator) {
		return () -> {
			T produce = producer.produce();
			return configurator.configure(produce);
		};
	}

}
