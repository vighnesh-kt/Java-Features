package PredefinedfunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionImpl {

	public static void main(String[] args) {

		// takes String and and return length
		List<String> strList = List.of("123", "1234", "12", "1");
		Function<String, Integer> returnLength = str -> str.length();
		List<Integer> size = eleSize(strList, returnLength);

		System.out.println(strList);
		System.out.println(size);

	}

	private static <T, R> List<R> eleSize(List<T> strList, Function<T, R> returnLength) {
		List<R> eleSize = new ArrayList<>();
		for (T t : strList) {
			eleSize.add(returnLength.apply(t));
		}
		return eleSize;
	}

}
