package Generics;

public interface GenericInterface<T> extends BaseInterface<T> {

	T getData();

	void setData(T data);

}

interface BaseInterface<T> {

}
