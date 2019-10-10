package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _146_LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache( 2 /* capacity */ );
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3);                  // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4);                  // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4

	}
	
	static class LRUCache {

		private int capacity;
		private int currentSize;
		private DLL dll;
		private Map<Integer, Node> keyDllNodeMap;
		
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        dll = new DLL();
	        keyDllNodeMap = new HashMap<>();
	    }
	    
	    //return -1 if the key is not present in the cache
	    public int get(int key) {
	      if(keyDllNodeMap.containsKey(key)) {
	    	int val = keyDllNodeMap.get(key).value;
	    	put(key,val);
	    	return val;
	      } 
	      return -1;
	    }
	    
	    //if the cache is full, evict the least recently used element. And insert this key,val
	    //put logic : add if new at the end of the linked list
	    //if already existing remove from it's position and insert at end
	    public void put(int key, int value) {
	    	if(!keyDllNodeMap.containsKey(key)) {
	    		//CASE : NEW NODE
	    		if(cacheIsFull()) evict();
	    		Node newNode = new Node(key, value);
	    		dll.insertAtEnd(newNode);
	    		keyDllNodeMap.put(key, newNode);
	    		currentSize++;
	    	} else {
	    		//CASE : UPDATING EXISTING NODE
	    		Node existingNode = keyDllNodeMap.get(key);
	    		existingNode.value = value;
	    		dll.remove(existingNode);
	    		dll.insertAtEnd(existingNode);
	    	}
	    }
	    
	    private void evict() {
		    Node node = dll.head;
		    dll.remove(node);
		    keyDllNodeMap.remove(node.key);
	    	currentSize--;
		}

		private boolean cacheIsFull() {
			return currentSize == capacity;
		}

		class Node {
    		public Node(int key, int value) {
    			this.key = key;
    			this.value = value;
			}
    		private int key;
			private int value;
    		private Node next;
    		private Node prev;
    	}
	    
	    class DLL {
	    	Node head;
	    	Node tail;
			public void remove(Node existingNode) {
				Node prev = existingNode.prev;
				Node next = existingNode.next;
				if (prev != null) {
					prev.next = next;
				}
				if (next != null) {
					next.prev = prev;
				}
				if (existingNode == head) {
					head = next;
				}
				if (existingNode == tail) {
					tail = prev;
				}
				existingNode.prev = null;
                existingNode.next = null;
			}
			public void insertAtEnd(Node n) {
	    		if(head == null) {
	    			head = n;
	    			tail = n;
	    		} else {
	    			tail.next = n;
	    			n.prev = tail;
	    			tail = n;
	    		}
	    	}
	    }
	}

}
