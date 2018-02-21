import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {

	private int capacity;
	private int size;
	private HashMap<Integer, Node> map;
	private Node first,last;
	
	
	public LRUCache(int capacity) {
       this.capacity = capacity;
       size = 0;
       map = new HashMap<>();
       first = last = null;
	}

	public int get(int key) {
        Node n = map.get(key);
        updateCache(n);
        if(n!=null)return n.val;
		return -1;
	}

	public void set(int key, int value) {
		if(map.get(key)==null)
		evict();
		insert(key,value);
	}
	
	private void evict() {
		if(size>=capacity) {
		    Node temp = first;
			first= first.next;
			if(first==null) {
				first=null;
				last=null;
			}else {
				first.prev = null;
			}
			map.remove(temp.key);
			size--;
		}
	}

	private void insert(int key, int value) {
		if(map.get(key)==null) {
			Node node = new Node(key, value);
			map.put(key, node);
			if(first==null) {
				first = node;
				last = node;
			}else {
				last.next=node;
				node.prev=last;
				last=node;
			}
		    size++;
		}else {
			Node node = map.get(key);
			node.val=value;
			updateCache(node);
		}
	}
	
	private void updateCache(Node node) {
		if(node==null)return;
		if(last==node) {
			//Do nothing
		}else if(first==node) {
			first = first.next;
			first.prev = null;
			
			last.next = node;
			node.prev = last;
			node.next = null;
			last = node;
		}else {
			Node prev = node.prev;
			Node next = node.next;
			prev.next = next;
			next.prev = prev;
			
			last.next = node;
			node.prev = last;
			node.next = null;
			last = node;
			
		}
	}
	
	class Node{
		int key;
		int val;
		Node prev;
		Node next;
		Node(int k, int v){key = k;val=v;}
	}
	
	public static void main(String args[]) {
		LRUCache c = new LRUCache(2);
		System.out.println(c.get(2) + " size= "+ c.size);
		c.set(2, 6);
		System.out.println(c.get(1) + " size= "+ c.size);
		c.set(1, 5);
		c.set(1, 2);
		System.out.println(c.get(1) + " size= "+ c.size);
		System.out.println(c.get(2) + " size= "+ c.size);
		 LinkedHashMap<Integer, String> l = null;
	}

}
