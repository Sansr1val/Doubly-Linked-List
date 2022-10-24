
public class DoublyLinkedList {
	
	private Node head;
	private Node tail;
	private int size;

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	public int Size() {
		return size;
	}
	
	public void Add(Node node) {
		if(head == null) {
			head = node;
			tail = node;
			size++;
		}else {
			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;
			size++;
		}
	}
	public void AddFirst(Node node) {
		head.setPrevious(node);
		node.setNext(head);
		head = node;
		size++;
	}
	/*
	 * Adds a node after the specified position
	 * Allows traversal from head or from tail
	 */
	public void AddAfter(int position, int data) {
		Node node = new Node(data);
		Node currentNode = head;
		if(position<=0 || position >size) {
			System.out.println("Invalid position.");
		}if(position == size){
			this.Add(node);
		}
		else {
			//traversal from head
			if(position<= (size/2)) {
				for (int i = 2; i <=position;i++) {
					currentNode = currentNode.getNext();
				}
			}
			//traversal from tail
			if(position> (size/2)) {
				currentNode = tail;
				for(int i = size; i>position; i--) {
					currentNode = currentNode.getPrevious();
				}
			}
			System.out.println(currentNode);
			Node next = currentNode.getNext();
			node.setPrevious(currentNode);
			node.setNext(next);
			currentNode.setNext(node);
			if(next != null) {
				next.setPrevious(node);
			}
			size++;
		}
	}
	/*
	 * Adds a node before the specified position.
	 * Allows traversal from head and from tail.
	 */
	public void AddBefore(int position, int data) {
		Node node = new Node(data);
		Node currentNode = head;
		if(position<=0 || position >size) {
			System.out.println("Invalid position.");
		}if(position == 1){
			this.AddFirst(node);
		}else {
			//traversal from head
			if(position<= (size/2)) {
				for (int i = 2; i <=position;i++) {
					currentNode = currentNode.getNext();
				}
			}
			//traversal from tail
			if(position> (size/2)) {
				currentNode = tail;
				for(int i = size; i>position; i--) {
					currentNode = currentNode.getPrevious();
				}
			}
			Node previousNode = currentNode.getPrevious();
			previousNode.setNext(node);
			node.setPrevious(previousNode);
			node.setNext(currentNode);
			currentNode.setPrevious(node);
			size++;
		}
	}
	
	public void Delete() {
		Node nodePrevTail = tail.getPrevious();
		tail.setPrevious(null);
		nodePrevTail.setNext(null);
		tail = nodePrevTail;
		size--;
	}
	public void DeleteFirst() {
		Node afterHead = head.getNext();
		head.setNext(null);
		head = afterHead;
		size--;
	}
	/*
	 * Deletes a Node at a specified position.
	 * Allows traversal from head or from tail.
	 */
	public void DeleteAt(int position) {
		if(position<=0 || position >size) {
			System.out.println("Invalid position.");
		}if(position == 1) {
			this.DeleteFirst();
		}if(position == size) {
			this.Delete();
		}
		else {
			Node currentNode = head;
			//traversal from head
			if(position<= (size/2)) {
				for (int i = 2; i <=position;i++) {
					currentNode = currentNode.getNext();
				}
			}
			//traversal from tail
			if(position> (size/2)) {
				currentNode = tail;
				for(int i = size; i>position; i--) {
					currentNode = currentNode.getPrevious();
				}
			}
			Node previous = currentNode.getPrevious();
			Node next = currentNode.getNext();
			previous.setNext(next);
			if(next != null) {
				next.setPrevious(previous);
			}
			currentNode.setNext(null);
			currentNode.setPrevious(null);
			size--;
		}
	}
	public void Display() {
		Node currentNode = head;
		String str = "";
		while(currentNode != null) {
			str += String.valueOf(currentNode.getData()) +", ";
			currentNode = currentNode.getNext();
		}
		if(str !="") {
			str = str.substring(0,str.length() -2);
		}
		System.out.println(str);
	}
	
	public void DisplayReverse() {
		Node currentNode = tail;
		String str = "";
		while(currentNode != null) {
			str += String.valueOf(currentNode.getData()) +", ";
			currentNode = currentNode.getPrevious();
		}
		if(str !="") {
			str = str.substring(0,str.length() -2);
		}
		System.out.println(str);
	}
}
