
public class Main {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.Add(new Node(1));
		list.Add(new Node(2));
		list.Add(new Node(3));
		list.Add(new Node(4));
		list.Add(new Node(5));
		System.out.println(list.Size());
	}

}
