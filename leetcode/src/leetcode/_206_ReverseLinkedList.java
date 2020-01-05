package leetcode;

public class _206_ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;

		ListNode prev = null, next = head;
		ListNode current = head;
		while (next != null) {
			current = next;
			next = current.next;
			current.next = prev;
			prev = current;
		}
		return current;
	}
	
	public ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}