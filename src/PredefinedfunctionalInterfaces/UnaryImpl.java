package PredefinedfunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryImpl {

	public static void main(String[] args) {
		List<Integer> intList=List.of(5,5,5,5);
		UnaryOperator<Integer> multiply=s->s*10;
		List<Integer>newIntList=mul(intList,multiply);
		System.out.println(intList);
		System.out.println(newIntList);
		
	}

	private static <T> List<T> mul(List<T> intList, UnaryOperator<T> multiply) {
		List<T> newList=new ArrayList<>();
		for(T t:intList) {
			newList.add(multiply.apply(t));
		}
		return newList;
		
	}

}
