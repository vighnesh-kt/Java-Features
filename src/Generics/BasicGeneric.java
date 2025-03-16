package Generics;

class Data{
	
	Object data;

	public Data(Object data) {
		// TODO Auto-generated constructor stub
		this.data=data;
	}

	@Override
	public String toString() {
		return "Data Data =" + data + "";
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}

class GenericData<T>{
	
	//t type parameter
	T data;

	public GenericData(T data) {
		// TODO Auto-generated constructor stub
		this.data=data;
	}

	@Override
	public String toString() {
		return "Data Data =" + data + "";
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}

public class BasicGeneric {
	
	public static void main(String[] args) {
		
		Data data=new Data("This is Data 1");
		System.out.println(data.toString());
		
		Data data2=new Data(2);
		System.out.println(data2.toString());
		
//		int i=(int)data.getData();//type error
		
		GenericData<String> d1=new GenericData<>("String data");
		GenericData<Integer>d2=new GenericData<>(12);
		
//		int i=(int)d1.getData();//type error in compile time
		
		
	}

}
