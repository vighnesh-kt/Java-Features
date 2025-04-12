package PredefinedfunctionalInterfaces;

import java.util.function.Supplier;

public class SupplierImpl {

	public static void main(String[] args) {

		// get object when need
		Supplier<String> supp = () -> new String("Hello Java");
		System.out.println(supp.get());

		// generating random number
		Supplier<Integer> randomNumber = () -> (int) (Math.random() * 10) + 1;
		System.out.println(randomNumber.get());
	}

}
