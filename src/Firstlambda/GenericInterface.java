package Firstlambda;

@FunctionalInterface
public interface GenericInterface<T,R> {
	
	R execute(T t);

}
