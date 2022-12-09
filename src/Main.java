import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static CircularDoublyLinkedList list = new  CircularDoublyLinkedList();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * The main menu of the program.
		 * Enter the command to utilize the functions of the Queue class
		 * Only Integers are allowed as inputs.
		 * The input value must not go out of bounds, it must be within the domain of the
		 * available inputs.
		 */
		int command;
		//It is contain in a loop so that it will show again and again until the user decides to exit the program.
		while(true) {
			try {
				System.out.println("\n----------Main Menu----------");
				System.out.println("[1] Append");
				System.out.println("[2] Display");
				System.out.println("[3] Merge All Duplicates");
				System.out.println("[4] Exit");
				System.out.print("Enter Command: ");
				command = Integer.parseInt(in.readLine());
				if(command >5 || command<1) {
					System.out.println("Input command is out of bounds. Try again.");
				}else {
					switch(command) {
					case 1:
						//Append method call
						Append();
						break;
					case 2:
						//Displays the List's contents
						System.out.println(list.Display());
						break;
					case 3:
						//MergeAllDuplicates Method call
						MergeAllDuplicates();
						break;
					case 4:
						//Exits the program
						System.out.println("Thank you, see you again!");
						System.exit(0);
					}
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Integer only! Try again.");
			}
		}
		
		
		
	}
	
	
	/*
	 * Asks the user to insert an integer.
	 * The input values is validated, integers are only allowed.
	 * If valid, the input is added into the List.
	 */
	public static void Append() throws IOException {
		try {
			System.out.print("Enter the number to Append: ");
			int number = Integer.parseInt(in.readLine());
			list.Add(number);
			System.out.println("Appended: "+number);
			
		} catch (NumberFormatException e) {
			System.out.println("Integer only! Try again.");
		}
	}
	
	/*
	 * Calls the MergeAllDuplicates() method of the list.
	 */
	public static void MergeAllDuplicates() {
		System.out.println("Merging duplicates ...\n");
		list.MergeAllDuplicates();
		System.out.println("MergeAllDuplicates Operation Completed!");
	}
}
