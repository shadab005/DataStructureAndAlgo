
class Node {
	Node(int x) {
		id = x;
	}

	int id;
	Node left;
	Node right;
}

public class LRUCache {

	Node head, tail;
	Node[] page;
	int cacheSize = 0;
	int countPageFault = 0;
	int pageCount = 0;
	int hit = 0;

	public LRUCache(int x) {
		cacheSize = x;
		page = new Node[100];
	}

	int lookup(int pageid) {
		
		System.out.println("Page lookup for " + pageid +" Number of pages " + pageCount);
		if (page[pageid] == null) {
			System.out.println("Cache miss");
			countPageFault++;
			if (pageCount >= cacheSize) { //Cache Full case
				pageCount++;
				//Replacing the front node of dll
				Node first = head;
				head = head.right;
				head.left=null;
				page[first.id]=null;
				Node n = new Node(pageid);
				page[pageid] = n;
				insertAtEnd(n);
			} else {
				Node n = new Node(pageid);
				page[pageid] = n;
				insertAtEnd(n);
			}
		} else {
			// Cache Hit
			hit++;
			Node n = page[pageid];
			Node prev = n.left;
			Node next = n.right;
			if(prev==null){
				head=next;
				head.left=null;
				insertAtEnd(n);
			}else if(next==null){
				
			}else{
				prev.right=next;
				next.left=prev;
				insertAtEnd(n);
			}
		}
		
		displayDll();
		return pageid;
	}

	private void displayDll() {
		Node n = head;
		while(n!=null){
			System.out.print(n.id +" ");
			n=n.right;
		}
		System.out.println();
		
	}

	private void insertAtEnd(Node n) {
		if(n==null)return;
		if(tail==null){
			head=tail=n;
			n.left=null;n.right=null;
		}else{
			tail.right = n;
			n.left = tail;
			n.right = null;
			tail=n;
		}
	}

	public static void main(String[] args) {
		int pages[] = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};//{ 1, 2, 3, 1, 4, 2, 5 };
		LRUCache l = new LRUCache(3);
		for (int i = 0; i < pages.length; i++) {
             l.lookup(pages[i]);
		}
		System.out.println(l.countPageFault);
		System.out.println(l.hit);
	}

}
