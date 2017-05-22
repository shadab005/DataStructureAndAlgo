import datastructure.linkedlist.LList;
import datastructure.linkedlist.Node;

public class MergeSortLinkedList {

	public static Node sort(Node first, Node last) {
		if (first != null && first != last) {
			Node mid = split(first, last);
			Node midnext = mid.next;
			mid.next = null;
			first = sort(first, mid);
			midnext = sort(midnext, last);
			first = simpleMerge(first, midnext);
		}
		return first;
	}
	
	//Alternate sort function
	public static Node mergeSort(LList list) {
		Node first = null;
		if (list.head != null && list.head.next!=null) {
			Node mid = list.getMid();
			Node midnext = mid.next;
			mid.next = null;
			LList secondHalf = new LList();
			secondHalf.head = midnext;
			first = mergeSort(list);
			midnext = mergeSort(secondHalf);
			list.head = simpleMerge(first, midnext);
		}
		return list.head;
	}
	

	public static Node split(Node first, Node second) {
		Node slow = first, fast = first;
		if (fast == second)	return fast;
		
		while (fast != second && fast.next != second) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static Node simpleMerge(Node n1, Node n2) {
		if (n1 == null)	return n2;
		else if (n2 == null)return n1;

		Node node1 = n1;
		Node node2 = n2;

		Node head = null, n = null;
		if (node1.data < node2.data) {
			head = n = node1;
			node1 = node1.next;
		} else {
			head = n = node2;
			node2 = node2.next;
		}
		while (node1 != null && node2 != null) {
			if (node1.data < node2.data) {
				n.next = node1;
				n = node1;
				node1 = node1.next;
			} else {
				n.next = node2;
				n = node2;
				node2 = node2.next;
			}
		}
		while (node1 != null) {
			n.next = node1;
			n = n.next;
			node1 = node1.next;
		}
		while (node2 != null) {
			n.next = node2;
			n = n.next;
			node2 = node2.next;
		}
		return head;
	}

	public static void main(String args[]) {
		LList l = new LList();
		l.add(13);
		l.add(4);
		l.add(7);
		l.add(3);
		l.add(5);
		l.add(10);
		//l.head=sort(l.head, l.getLastNode());
		l.head=mergeSort(l);
		System.out.println(l);
		
	}
}
