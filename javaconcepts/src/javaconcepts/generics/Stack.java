package javaconcepts.generics;

import java.util.Iterator;

/*
 * Array cannot be directly created using generic
 * Ex: s = new Item[capacity] cannot be done for technical reason
 * Therefore We have to use s = (Item[]) New Object[capacity]
 * Note: In general avoid casting
 */

/*
 * Iteratable :  has method iterator that returns Iterator 
 * Iterator has methods: hasNext(), next(), remove
 * 
 */
public class Stack<Item> implements Iterable<Item>{

	private Node first = null;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(Item item) {
		Node temp = new Node();
		temp.item = item;
		temp.next = first;
		first = temp;
	}

	public Item pop() {
		if (first == null)
			return null;
		Node temp = first;
		first = temp.next;
		return temp.item;
	}

	public static void main(String[] args) {
		Stack<String> s = new Stack<>(); // In java 6, you must specify the
											// String in the other <> also
		s.push("Shadab");
		s.push("sud");
		s.push("ayubi");
		s.push("anoop");
		while (!s.isEmpty())
			System.out.println(s.pop());
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}

}
