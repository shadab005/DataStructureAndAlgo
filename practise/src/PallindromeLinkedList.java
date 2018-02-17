
public class PallindromeLinkedList {

	public static void main(String[] args) {
		PallindromeLinkedList l = new PallindromeLinkedList();
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(2);
		n1.next.next = new ListNode(2);
		n1.next.next.next = new ListNode(3);
		//n1.next.next.next.next = new Node(3);
		n1.next.next.next.next = new ListNode(2);
		n1.next.next.next.next.next = new ListNode(3);
		n1.next.next.next.next.next.next = new ListNode(1);
		l.print(n1);
		// l.print(l.reverseList(n1));
		System.out.println(l.lPalin(n1));

	}

	public int lPalin(ListNode head) {
		if (head == null)return 0;
		ListNode mid = getMid(head);
		ListNode reverse = reverseList(mid.next);
		mid.next = null;
		while (reverse != null && head.val == reverse.val) {
			head = head.next;
			reverse = reverse.next;
		}
		if (reverse != null)
			return 0;
		return 1;
	}

	public ListNode getMid(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		ListNode next = head;
		while (next != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public void print(ListNode head) {
		while (head != null) {
			System.out.print(head + "-->");
			head = head.next;
		}
		System.out.println("NULL");
	}

	static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}

		public String toString() {
			return "[" + val + "]";
		}
	}

}
