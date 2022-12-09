
public class Node {
	//Class fields
	private int data;
	private Node next;
	private Node previous;
	
	//Constructors, non-parameterized and parameterized.
	public Node() {
		this.data = 0;
		this.next = null;
		this.previous = null;
	}
	
	public Node(int data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}
	
	//setters/getters
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getPrevious() {
		return previous;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
}
