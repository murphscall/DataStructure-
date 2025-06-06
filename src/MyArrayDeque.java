public class MyArrayDeque {
	private Object[] elements;
	private int size;
	private int front;
	private int rear;
	private static final int DEFAULT_CAPACITY = 10;

	public MyArrayDeque() {
		elements = new Object[DEFAULT_CAPACITY];
		size = 0;
		front = 0;
		rear = 0;
	}

	private int capacity() {
		return elements.length;
	}

	private void grow() {
		int newCapacity = elements.length + 5;
		Object[] newArray = new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newArray[i] = elements[(front + i) % elements.length];
		}
		elements = newArray;
		front = 0;
		rear = size;
	}



}
