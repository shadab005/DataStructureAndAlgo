package datastructure.dll;


public class DoublyLinkedList {

	public Node head, tail;

	public void add(int data) {
		Node temp = new Node(data);
		if (head == null) {
			head = tail = temp;
		} else {
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}
	}

	public void traverse() {
		 String ret = "";
		  Node temp = head;
		  while(temp != null){
			  ret = ret + "[" + temp.data + "] -->"; 
			  temp = temp.next;
		  }
		  ret = ret + "NULL";
		  System.out.println(ret);
	}
	
	public void traverseReverse() {
		 String ret = "";
		  Node temp = tail;
		  while(temp != null){
			  ret = ret + "[" + temp.data + "] -->"; 
			  temp = temp.prev;
		  }
		  ret = ret + "NULL";
		  System.out.println(ret);
	}

	@Override
	public String toString() {
		String ret = "";
		Node temp = head;
		while (temp != null) {
			ret = ret + "[" + temp.data + "] -->";
			temp = temp.next;
		}
		ret = ret + "null";
		return ret;
	}
	
	public static void main(String args[]){
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.add(3);
		dll.add(5);
		dll.add(1);
		dll.add(7);
		System.out.println(dll);
		dll.traverse();
		dll.traverseReverse();
	}

}
