package FunctionalProgrammingTechniques.FunctionComposition;



public class FunctionConposition {

	public static void main(String[] args) {
		
		//using inbuilt function
		
		//Function<Integer, Integer> f1=s->s+5;
		//Function<Integer, Integer> f2=s->s*5;
		
		//Function<Integer, Integer> f3=f1.compose(f2);//right to left
		//System.out.println(f3.apply(5));
		
		//Custom function compositoon
		Function<Square, Integer> f1=s->s.getArea();
		Function<Integer, Double> f2=s->Math.sqrt(s);

		
		Function<Square, Double> getSide =f2.compose(f1);
		
		Square s = new Square();
		s.setArea(100);
		
		Double side = getSide.apply(s);
		
		System.out.println(side);
		
	}
}
