import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
	private int maxSize, size;
	private Object[] stack;
	public MyStack() {
		maxSize = 255;
		size = 0;
		stack = new Object[maxSize];
	}
	public MyStack(int size) {
		maxSize = size;
		this.size = 0;
		stack = new Object[maxSize];
	}
	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(size == maxSize) {
			return true;
		}
		return false;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		return (T)stack[--size];
		
	}

	@Override
	public T top() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		return (T)stack[size - 1];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		stack[size++] = e;
		return true;
	}

	@Override
	public String toString(String delimiter) {
		String temp = "";
		for(int i = 0; i < size -1; i++) {
			temp += stack[i] + delimiter;
		}
		temp+= stack[size - 1];
		return temp;
	}
	@Override
	public String toString() {
		String temp = "";
		for(int i = 0; i < size; i++) {
			temp += stack[i];
		}
		return temp;
	}
	

	@Override
	public void fill(ArrayList list) throws StackOverflowException {
		for(int i = 0; i < list.size(); i++) {
			if(isFull()) {
				throw new StackOverflowException();
			}
			stack[size] = list.get(i);
			size++;
		}
		
	}

}
