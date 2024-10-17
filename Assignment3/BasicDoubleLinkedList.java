import java.util.*;



public class BasicDoubleLinkedList<T> implements Iterable<T>{
	protected Node head;
	protected Node tail;
	protected int size;
	public BasicDoubleLinkedList() {
		head = new Node(null);
		tail = new Node(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	public void addToEnd(T data) {
		Node prevNode = tail.prev;
		Node newNode = new Node(data);
		newNode.next = tail;
		newNode.prev = prevNode;
		prevNode.next = newNode;
		tail.prev = newNode;
		size++;
	}
	
	public void addToFront(T data) {
		Node nextNode = head.next;
		Node newNode = new Node(data);
		newNode.prev = head;
		newNode.next = nextNode;
		nextNode.prev = newNode;
		head.next = newNode;
		size++;
	}
	
	public T getFirst() {
		return head.next.data;
	}
	
	public T getLast() {
		return tail.prev.data;
	}
	
	public int getSize() {
		return size;
	}
	
	public DoubleLinkedListIterator<T> iterator(){
		DoubleLinkedListIterator a = new DoubleLinkedListIterator();
		return a;
	}
	
	public Node remove(T data,Comparator<T> comparator) {
		Node thisNode = head;
		Node nextNode = head.next;
		Node prevNode;
		for(int i = 0; i < size;i++) {
			prevNode = thisNode;
			thisNode = nextNode;
			nextNode = thisNode.next;	
			if(comparator.compare(data,thisNode.data) == 0) {
				Node temp = thisNode;
				nextNode.prev = prevNode;
				prevNode.next = nextNode;
				size--;
				return temp;
			}
		}
		return null;
	}
	
	public T retrieveFirstElement() {
		Node temp = head.next;
		head.next = temp.next;
		head.next.prev = head;
		return temp.data;
	}
	
	public T retrieveLastElement() {
		Node temp = tail.prev;
		tail.prev = temp.prev;
		tail.prev.next = tail;
		return temp.data;
	}
	
	public ArrayList<T> toArrayList(){
		ArrayList<T> list = new ArrayList<T>();
		Node thisNode = head;
		for(int i = 0; i < size; i++) {
			thisNode = thisNode.next;
			list.add(thisNode.data);
		}
		return list;
	}
	
	public class Node{
		public T data;
		public Node next;
		public Node prev;
		public  Node(T data) {
			this(data, null, null);
		}
		private Node(T data, Node nextNode, Node previous) {
			this.data = data;
			next = nextNode;
			this.prev = previous;
		}
		 public String toString() {
			return data.toString();
		}
		 public boolean equals(Node compare) {
			 if(compare.data.equals(this.data)) {
				 return true;
			 }
			 return false;
		 }
	}
	public class DoubleLinkedListIterator<T> implements ListIterator{
		private Node nodeNext, nodePrev;
		
public DoubleLinkedListIterator() {
			nodeNext = head.next;
			nodePrev = head;
		}
		@Override
		public boolean hasNext() {
			if(nodeNext.data == null) {
				return false;
			}
			return true;
		}

		@Override
		public T next() {
			if(!(this.hasNext())) {
				throw new NoSuchElementException();
			}
			T temp = (T) nodeNext.data;
			nodeNext = nodeNext.next;
			nodePrev = nodePrev.next;
			return temp;
		}

		@Override
		public boolean hasPrevious() {
			if(nodePrev.data == null) {
				return false;
			}
			return true;
		}

		@Override
		public T previous() {
			if(!(this.hasPrevious())) {
				throw new NoSuchElementException();
			}
			T temp = (T) nodePrev.data;
			nodeNext = nodeNext.prev;
			nodePrev = nodePrev.prev;
			return  temp;
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(Object e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(Object e) {
			throw new UnsupportedOperationException();
		}
		
	}

}
