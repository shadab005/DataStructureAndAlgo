import datastructure.dll.DoublyLinkedList;
import datastructure.dll.Node;

public class QuickSortInDLL {
	
	public static void quickSort(Node first, Node last){
		if(first!=null && first != last){
			Node pivotNode = partition(first,last);
			if(pivotNode != first) quickSort(first, pivotNode.prev);
			if(pivotNode!=last) quickSort(pivotNode.next, last);
		}
	}
	
	private static Node partition(Node first, Node last) {
		Node pivot = first;
		first = first.next;
		while(true){
		   while(first!=last && first.data < pivot.data) first = first.next;
		   while(pivot.data < last.data) last = last.prev;
		   if(first!=last.next && first!=last){
			  swap(first, last);
		   }else{
			   swap(pivot,last);
			   return last;
		   }
		}
	}

	private static void swap(Node first, Node last) {
		int data = first.data;
		first.data = last.data;
		last.data = data;
	}


	public static void main(String args[]) {
		DoublyLinkedList dll = new DoublyLinkedList();
		//dll.add(10);
		dll.add(3);
	 	dll.add(15);
		dll.add(7);
		/*dll.add(19);
		dll.add(18);*/
		System.out.println(dll);
		quickSort(dll.head, dll.tail);
		System.out.println(dll);
	}
}
