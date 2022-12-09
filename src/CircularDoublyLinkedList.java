
public class CircularDoublyLinkedList {
	//class fields
	private Node head;
	private Node tail;
	//setters/getters
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
	
	
	/*
	 * Adds a node into the list
	 * If the list is empty, the first node is both the 
	 * head and the tail.
	 * Else, the new node is added at the tail and becomes the 
	 * new tail.
	 */
	public void Add(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
			tail = node;
			tail.setNext(head);
			tail.setPrevious(head);
			head.setPrevious(tail);
			head.setNext(tail);
		}else {
			tail.setNext(node);
			node.setPrevious(tail);
			head.setPrevious(node);
			node.setNext(head);
			tail = node;
		}
	}
	/*
	 * Deletes all duplicates except the first occurences.
	 * Operation won't proceed if the list is null.
	 * A prompt will show if the list had no duplicates.
	 *A loop with the pointer currentNode acts as the key and then another loop
	 *with the pointer traversingNode checks if it is a duplicate if currentNode.
	 *If true, the Node of traversingNode is deleted.
	 *A separate delete operation is used when the current traversingNode is the tail.
	 *Any node in between is deleted as normal.
	 */
	public void MergeAllDuplicates() {
		if(head == null) {
			System.out.println("The list is empty\n");
		}else {
			boolean hasDuplicate = false;
			Node currentNode = head;
			//first loop, stops when the next of the node is the head
			while(currentNode.getNext() !=head) {
				Node traversingNode = currentNode.getNext();
				//second loop, stops when the traversing node is the head.
				while(traversingNode!=head) {
					if(traversingNode.getData() == currentNode.getData()){
						
						if(traversingNode == tail) {
							head.setPrevious(tail.getPrevious());
							tail = tail.getPrevious();
							tail.setNext(head);
						}else {
							traversingNode.getNext().setPrevious(traversingNode.getPrevious());
							traversingNode.getPrevious().setNext(traversingNode.getNext());
						}
						hasDuplicate = true;
					}
					traversingNode = traversingNode.getNext();
				}
				currentNode = currentNode.getNext();
			}
			/*
			 * If the list is detected to contain no duplicates,
			 * a prompt will show telling the user of the case.
			 */
			if(!hasDuplicate) {
				System.out.println("The list has no duplicates!\n");
			}
		}
	}
	
	/*
	 * Displays the contents of the list from head to tail
	 */
	public String Display() {
		if(head == null ) {
			return "The list is empty!\n";
		}else {
			String str = "List content: ";
			Node currentNode = head; 
			do{
				str+= currentNode.getData()+", ";
				currentNode = currentNode.getNext();
			}while(currentNode!=head); 
			
			return  str.substring(0,str.length()-2);
		}
		
	}
	/*
	 * Displays the contents of the list from tail to head.
	 */
	public String DisplayReverse() {
		if(head == null ) {
			return "The list is empty!\n";
		}else {
			String str = "List content: ";
			Node currentNode = tail; 
			do{
				str+= currentNode.getData()+", ";
				currentNode = currentNode.getPrevious();
			}while(currentNode!=tail); 
			
			return  str.substring(0,str.length()-2);
		}
		
	}
}
