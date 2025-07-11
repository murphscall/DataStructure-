package list;

public class MyArrayList<T> {
	private Object[] elements;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;


	public MyArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	public void add(T element) {
		if(size == elements.length){
			grow();
		}
		elements[size++] = element;
	}

	public void grow(){
		int newCapacity = elements.length + 5;
		Object[] newElements = new Object[newCapacity];
		for(int i= 0; i< elements.length; i++){
			newElements[i] = elements[i];
		}
		elements = newElements;
	}

	public T get(int index){
		if(index < 0 || index >= size){
			System.out.println("Index out of bounds");
		}
		return (T) elements[index];
	}

	public int size(){
		return size;
	}

	public int capacity(){
		return elements.length;
	}
}
