
public class RemoveNthNodeFromListEnd {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(2);
		/*n1.next.next = new ListNode(3);
		n1.next.next.next = new ListNode(4);
		n1.next.next.next.next = new ListNode(5);*/
		
		RemoveNthNodeFromListEnd r =  new RemoveNthNodeFromListEnd();
		//r.printList(n1);
		ListNode ans = r.removeNthFromEnd(n1, 1); 
		r.printList(ans);

	}
	
	private void printList(ListNode n1) {
		while(n1!=null) {
			System.out.println(n1.val+" ");
			n1=n1.next;
		}
	}

	public ListNode removeNthFromEnd(ListNode l, int k) {
		ListNode slow = l;
		ListNode fast = l;
		int m = k;
		while(m-->0 && fast!=null) {
			fast = fast.next;
		}
		if(m>=0) {
			l = l.next;
			return l;
		}
		while(fast!= null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next;
		}
		if(fast==null) {
			slow = slow.next;
			return slow;
		}
		slow.next = slow.next.next;
		return l;
    }

}



class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
