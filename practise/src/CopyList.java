import java.util.HashMap;

public class CopyList {

	private static class RandomListNode{
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null)return null;
		
		RandomListNode headNew = copy(head);
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		map.put(head, headNew);
		
		RandomListNode ptr = head;
		RandomListNode preptr = headNew;
		ptr = ptr.next;
		while(ptr!=null) {
			preptr.next=copy(ptr);
			map.put(ptr, preptr.next);
			preptr=preptr.next;
			ptr=ptr.next;
		}
        
		
		ptr = head;
		preptr = headNew;
				
		while(ptr!=null) {
			preptr.random = map.get(ptr.random);
			preptr = preptr.next;
			ptr = ptr.next;
		}
		
		return headNew;
	}
	
	private RandomListNode copy(RandomListNode head) {
		if(head==null)return null;
		RandomListNode x = new RandomListNode(head.label);
		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
