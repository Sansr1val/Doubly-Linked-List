
public class CircularDoublyLinkedList {
	
	private Node head;
	private Node tail;

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
	 * 
	 */
	public void MergeAllDuplicates() {
		if(head == null) {
			System.out.println("The list is empty\n");
		}else {
			boolean hasDuplicate = false;
			Node currentNode = head;
			while(currentNode.getNext() !=head) {
				Node traversingNode = currentNode.getNext();
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
			if(!hasDuplicate) {
				System.out.println("The list has no duplicates!\n");
			}
		}
	}
	
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
