package PredefinedfunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateImpl {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("");
		list.add("React");
		list.add("");
		// list.add(null);

		// check if list contain null
//		Predicate<List<String>>p=lst->lst.contains(null);
//		System.out.println(p.test(list));

		Predicate<String> p = (s) -> !s.isEmpty();
		// only non empty elements new list
		System.out.println(list);
		List<String> list2 = filterList(list, p);
		System.out.println(list2);

	}

	public static List<String> filterList(List<String> l, Predicate<String> p) {
		List<String> newList = new ArrayList<>();
		for (String s : l) {
			if (p.test(s)) {
				newList.add(s);
			}
		}
		return newList;
	}

	public static <T> List<T> genericFilterList(List<T> l, Predicate<T> p) {
		List<T> newList = new ArrayList<>();
		for (T s : l) {
			if (p.test(s))
				newList.add(s);
		}

		return newList;
	}

}
