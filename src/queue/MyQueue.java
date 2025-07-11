package queue;

public class MyQueue<T> {

	private Object[] elements;
	private int size;
	private int front;
	private int rear;
	private static final int DEFAULT_CAPACITY = 10;

	public MyQueue() {
		elements = new Object[DEFAULT_CAPACITY];
		size = 0;
		front = 0;
		rear = 0;
	}


	public void offer(Object element){
		if(size == elements.length){
			grow();
		}
		elements[rear] = element;
		rear = (rear + 1) % elements.length;
		size++;
	}

	public T poll(){
		T value = (T) elements[front];
		elements[front] = null;
		front = (front + 1) % elements.length;
		size--;
		return value;
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
