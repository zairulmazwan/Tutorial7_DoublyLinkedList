public class Collision {

	static DoublyLinkedList [] myTable = new DoublyLinkedList [5];
	
	public static void main(String[] args) {
		
		insert(9, "Zairul"); 
		insert(5, "Mazwan"); 
		//insert(12, "Jilani"); 
		insert(15, "Rania");
		//insert(13, "Bill Gate");
		insert(16, "John");
		insert(21, "Mariam");
		
		printData ();
	
	}
	
	public static void insert (int key, String name) {
		
		int index = hashFunction (key);
		DoublyLinkedList dll = new DoublyLinkedList();
		DoublyLinkedList.Node n = new DoublyLinkedList.Node(key, name);
		
		if (collision(index)==false) {
			dll.setHead(n);
			myTable [index] = dll;
		}
		else {
			dll = myTable[index];
			dll.insert(n);
		}
	}
	
	public static int hashFunction (int key) {
		int index = key%myTable.length;
		return index;
	}
	
	public static boolean collision (int index) {
		boolean coll = false;
		if (myTable[index]!=null) {
			coll = true;
		}
		return coll;
	} 

	public static void printData () {
		for (int i = 0; i<myTable.length; i++) {
			System.out.println("Index "+i+" : ");
			if (myTable[i]!=null) {
				System.out.println("There are "+myTable[i].length+ " record/s");
				DoublyLinkedList.printNodes(myTable[i]);
			}
			else {
				System.out.print("No record here!");
			}
			
			System.out.println("\n");
		}
	}


}
