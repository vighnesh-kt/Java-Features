package FunctionalProgrammingTechniques;

public class Closures {

	public static void main(String[] args) {

		int val = 100;
//		val=200;

		// Closure inside lambda
		Task task = () -> {
			System.out.println(val);
		};

		// closure inside method
		printValue(task);
	}

	private static void printValue(Task task) {
		// TODO Auto-generated method stub
		task.doTask();
	}
}
