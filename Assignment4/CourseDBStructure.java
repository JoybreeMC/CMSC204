import java.io.IOException;
import java.util.ArrayList;


public class CourseDBStructure implements CourseDBStructureInterface{
	Node[] hashArray;
	int[] size;
	int arraySize;
	CourseDBStructure(int n){
		int minSize = (int) ((n/1.5)+ 1);
		int size = minSize;
		boolean check = true;
		while(check) {
			boolean prime = true;
			for(int i = 2 ; i < size; i++) {
				if(size % i == 0) {
					prime = false;
				}
			}
			if(prime) {
				if((size - 3) % 4 == 0) {
					check = false;
				}
			} 
			size++;
			
		}
		
		//hashed = new DBLinkedList[size];
		arraySize = size-1;
		this.size = new int[size-1];
		hashArray = new Node[size-1];
		for(int i = 0; i < size-1;i++) {
			hashArray[i] = new Node(null);
		}
	}
	
	CourseDBStructure(String test, int size){
		//hashed = new DBLinkedList[size];
		arraySize = size;
		this.size = new int[size];
		hashArray = new Node[size];
		for(int i = 0; i < size;i++) {
			hashArray[i] = new Node(null);
		}
	}
	@Override
	public void add(CourseDBElement element) {
		String crn = "" + element.getCRN();
		int position = crn.hashCode() % arraySize;
		Node thisNode = hashArray[position];
		Node nextNode = thisNode.next;
		for(int i = 0; i < size[position];i++) {
			thisNode = nextNode;
			nextNode = nextNode.next;
			if(thisNode.data.compareTo(element) == 0) {
				thisNode.data = element;
				return;
			}
		}
		thisNode.next = new Node(element);
		size[position]++;
		
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		String a = "" + crn;
		int position = a.hashCode() % arraySize;
		Node thisNode = hashArray[position];
		Node nextNode = thisNode.next;
		CourseDBElement b;
		for(int i = 0; i < size[position]; i++) {
			thisNode = nextNode;
			nextNode = nextNode.next;
			if(thisNode.data.getCRN()==crn) {
				b = thisNode.data;

				return b;
			}
		}
		throw new IOException();
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i<arraySize; i++) {
			Node thisNode = hashArray[i];
			Node nextNode = thisNode.next;
			for(int j = 0; j < size[i]; j++) {
				thisNode = nextNode;
				nextNode = nextNode.next;
				list.add(thisNode.data.toString());
				
			}
		}
		return list;
	}

	@Override
	public int getTableSize() {
		return arraySize;
	}
	private class Node{
		private CourseDBElement data;
		private Node next;
		private Node(CourseDBElement data) {
			this(data, null);
		}
		private Node(CourseDBElement data, Node nextNode) {
			this.data = data;
			next = nextNode;
		}
		 public String toString() {
			return data.toString();
		}
	}
	
}
