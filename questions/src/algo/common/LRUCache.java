package algo.common;

import java.util.HashMap;

/*
 * LRU/Oldest accessed key is at the head of the linked list
 * Most recent access key is at the tail of the linked list
 * access : put/get
 * Map has key and value points to the node in the linked list
 * 
 * put, get => O(1)
 * 
 * It can also be implemented using linked hashmap.
 */
public class LRUCache {
	
	HashMap<Integer, Node> map;
	private Node head;
	private Node tail;
	private int capacity;
	private int size;
	
	class Node {
		Node(int k, int v){key=k;value=v;}
		int key;
		int value;
		Node left;
		Node right;
	}

	public LRUCache(int capacity) {
		map = new HashMap<>();
		this.capacity= capacity;
	}

	public int get(int key) {
		if(map.containsKey(key)) {
			//get the node and put it at end
			Node node = map.get(key);
			delete(node);
			insertAtEnd(node);			
			return node.value;
		}
		else return -1;
	}

	public void put(int key, int value) {		
		if(map.containsKey(key)) {
			//update the value in the Node and put the node at the end
			Node node = map.get(key);
			node.value = value;
			delete(node);
			insertAtEnd(node);
		} else {
			if(size == capacity) evict();
			//This is a new node case
			Node node = new Node(key,value);
			map.put(key, node);
			insertAtEnd(node);
			size++;
		}
		
	}
	
	private void insertAtEnd(Node node) {
		if(tail == null) {
			head = tail = node;
		} else {
			tail.right = node;
			node.left = tail;
			tail = node;
		}
	}


	private Node delete(Node node) {
		//if it is the first node
		//if it is the mid node
		//if it is the tail node
		if(head == node) {
			//first node case
			head = head.right;
			if(head==null) tail = null;
			else {
				head.left = null;
			}
		} else if (tail == node) {
			//last node case
			tail = tail.left;
			tail.right.left = null;
			tail.right = null;
		} else {
			//mid node case
			Node prev = node.left;
			Node next = node.right;
			
			prev.right = next;
			next.left = prev;
			node.left = node.right = null;
		}
		return node;
	}

	
	/*
	 * Evicts the LRU node (first node from DLL as per the implementation) from LinkedList and map and reduce size
	 */
	private void evict() {
		if(size > 0) {
			map.remove(head.key);
			head = head.right;
			if(head == null) tail = null;
			else head.left = null;
			size--;
		}
	}

	public static void main(String[] args) {
		LRUCache l = new LRUCache(1);
		l.put(2, 1);
		l.put(2, 2);
		System.out.println(l.get(2));
		l.put(1, 1);
		System.out.println(l.get(2));

	}

}
