
public class DoublyLinkedList {


	Node head;
	Node tail;
	int length=0;
	
	static class Node {
		int key;
		String data;
		Node next;
		Node previous;
		
		Node (int k, String d){
			this.key = k;
			this.data = d;
			next = null;
			previous = null;
		}
		
	}
	
	public void setHead (Node n) {
		head = n;
		tail = n;
		length++;
		
	}
	
	
	public void insert (Node n) {
		tail.next = n;
		n.previous = tail;
		tail = n;
		length++;
		
	}
	
	public void insertAfter (Node n, Node after) {
		Node next = after.next; //get the existing next node before inserting the new node
		after.next = n; //linking the after node to n as next
		n.previous = after; //linking the n node to after as previous
		n.next = next; //linking the n node to the existing next as next
		next.previous = n; //linking the next node to n as previous
		length++;
	}
	
	public void insertBefore (Node n, Node before) {
		Node previous = before.previous; //get the existing previous node before inserting the new node
		before.previous = n; //linking the before node to n as previous
		n.next = before; //linking the n node to before as next
		previous.next = n; //linking the previous node to n as next
		n.previous = previous; //linking the n node to existing previous node as previous
		length++;
	}
	
	
	public void remove (Node n) {
		//if the head to be deleted
		if (head.data == n.data) {
			head = head.next; //get the next of the head becomes as head
			head.previous = null;
			length--;
		}
		else if (tail.data == n.data) {
			tail = tail.previous;
			tail.next = null;
			length--;
		}
		else {
			Node current = head.next;
			Node previous = head;
			
			while (current!=null) {
				if(current.data == n.data) {
					Node newCurrent = current.next; 
					previous.next = newCurrent; 
					newCurrent.previous = previous;
					length--;
				}
				previous = current;
				current = current.next;
			}
		}
	}
	
	public boolean findNode (String x) {
		boolean res = false;
		Node current = head;

		if (current.data == x) {
			res = true;
		}
		else {
			for (int i=0; i<length-1; i++) {
				current = current.next;
				
				if (current.data==x) {
					res = true;
					break;
				}
			}
		}
		
		return res;
	}

	public static void printNodes (DoublyLinkedList nodes) {
		
		Node current = nodes.head;
		System.out.print("LinkedList: ");
		
		while(current!=null) {
			System.out.print(current.data);
			if (current.next!=null && current.previous!=null) {
				System.out.print("<=>");
			}
			
			else if(current.next!=null) {
				System.out.print("=>");
			}
			current = current.next;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
