
public class MyStack<T> {
	private Object[] elements;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;


	public MyStack() {
		elements = new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	public void push(Object element){
		if(size == elements.length){
			grow();
		}
		elements[size++] = element;

	}
	private void grow() {
		int newCapacity = elements.length + 5;
		Object[] newArray = new Object[newCapacity];
		System.arraycopy(elements, 0, newArray, 0, size);
		elements = newArray;
	}
	public Object pop(){
		if(size == 0){
			System.out.println("Stack is empty");
		}
		T value = (T) elements[--size];
		elements[size] = null;
		return value;
	}

	public Object peek(){
		if(size == 0){
			System.out.println("Stack is empty");
		}
		return elements[size-1];
	}
}
