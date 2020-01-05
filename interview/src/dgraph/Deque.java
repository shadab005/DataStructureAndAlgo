package dgraph;

import java.util.concurrent.atomic.AtomicInteger;


class Deque {
	
	static class Node {
		public Node(int x) {
			this.data = x;
		}
		int data;
		Node left;
		Node right;
	}
	
	
	AtomicInteger size = new AtomicInteger();
	
	Node head;
	Node tail;
	
	synchronized void push(int x) {
		if(head == null) {
			head = new Node(x);
			tail = head;
		} else {
			Node n = new Node(x);
			n.right = head;
			head.left = n;
			head = n;
		}
		size.incrementAndGet();
		System.out.println("Push size = " + size() + " Thread.id = " + Thread.currentThread().getId());
	}
	
	synchronized int pop() {
		if(size.get()==0) {
			System.out.println("Pop size = " + size() + " Thread.id = " + Thread.currentThread().getId());
			return -1;
		}
		Node n = null;
		if(size.get() == 1) {
			n = head;
			head = null;
			head = tail ;
		} else {
			n = head;
			head = head.right;
			head.left = null;
		}
		n.right = null;
		n.left = null;
		size.decrementAndGet();
		System.out.println("Pop size = " + size() + " Thread.id = " + Thread.currentThread().getId());
		return n.data;
	}
	
	synchronized int steal() {
		if(size.get()==0) {
			System.out.println("Steal size = " + size() + " Thread.id = " + Thread.currentThread().getId());
			return -1;
		}
		Node n = tail;
		if(size.get() == 1) {
			head = null;
			tail = head;
		} else {
			 tail = tail.left;
			 tail.right = null;
		}
		n.right = null;
		n.left = null;
		size.decrementAndGet();
		System.out.println("Steal size = " + size() + " Thread.id = " + Thread.currentThread().getId());
		return n.data;
	}
	
	public int size() {
		return size.get();
	}
}