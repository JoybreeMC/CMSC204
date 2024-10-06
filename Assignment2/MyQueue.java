import java.util.ArrayList;


public class MyQueue<T> implements QueueInterface<T> {
	int maxSize, size;
	private Node head;
	public MyQueue(int size) {
		maxSize = size;
		this.size = 0;
		head = new Node(null);
	}
	public MyQueue() {
		maxSize = 255;
		size = 0;
		head = new Node(null);
	}
	@Override
	//returns true if queue is empty false otherwise
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		
		return false;
	}

	@Override
	//returns true if queue is full false otherwise 
	public boolean isFull() {
		if(size == maxSize) {
			return true;
		}
		return false;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		T temp = head.next.data;
		head = head.next;
		head.data = null;
		size--;
		return temp;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		
		Node thisNode = head;
		Node nextNode = head.next;
		for(int i = 0; i < size; i++) {
			thisNode = nextNode;
			nextNode = nextNode.next;
		}
		thisNode.next = new Node(e);
		size++;
		return true;
	}

	@Override
	public String toString(String delimiter) {
		String temp = "";
		Node thisNode = head;
		for(int i = 0; i < size-1; i++) {
			thisNode = thisNode.next;
			temp += thisNode.data + delimiter;
		}
		thisNode = thisNode.next;
		temp+= thisNode.data;
		return temp;
	}
	@Override
	public String toString() {
		String temp = "";
		Node thisNode = head;
		for(int i = 0; i < size ; i++) {
			thisNode = thisNode.next;
			temp += thisNode.data;
		}
		return temp;
	}
	@Override
	public void fill(ArrayList<T> list)throws QueueOverflowException {
		Node thisNode = head;
		for(int i = 0; i < size; i ++) {
			thisNode = thisNode.next;
		}
		Node temp;
		for(int i = 0; i < list.size(); i++) {
			if (isFull()) {
				throw new QueueOverflowException();
			}
			temp = new Node(list.get(i));
			thisNode.next = temp;
			thisNode = thisNode.next;
			size++;
		}
		
	}
	private class Node{
		private T data;
		private Node next;
		private Node(T data) {
			this(data, null);
		}
		private Node(T data, Node nextNode) {
			this.data = data;
			next = nextNode;
		}
		 public String toString() {
			return data.toString();
		}
	}

}
