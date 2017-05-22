import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int size;

	private class Node {
		private Item item;
		private Node prev;
		private Node next;
	}

	public Deque() // construct an empty deque
	{
		size = 0;
	}

	public boolean isEmpty() // is the deque empty?
	{
		return first == null;
	}

	public int size() // return the number of items on the deque
	{
		return size;
	}

	public void addFirst(Item item) // add the item to the front
	{
		if (item == null)
			throw new java.lang.NullPointerException();
		if (first == null) {
			first = new Node();
			first.item = item;
			last = first;
		} else {
			Node temp = new Node();
			temp.item = item;
			temp.next = first;
			first.prev = temp;
			first = temp;
		}
		size++;
	}

	public void addLast(Item item) // add the item to the end
	{
		if (item == null)
			throw new java.lang.NullPointerException();
		if (first == null) {
			first = new Node();
			first.item = item;
			last = first;
		} else {
			Node temp = new Node();
			temp.item = item;
			temp.prev = last;
			last.next = temp;
			last = temp;
		}
		size++;
	}

	public Item removeFirst() // remove and return the item from the front
	{
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		Item item = first.item;
		first = first.next;
		if(first!=null) first.prev = null;
		size--;
		return item;
	}

	public Item removeLast() // remove and return the item from the end
	{
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		Item item = last.item;
		last = last.prev;
		if (last == null) {
			first = null;
		} else {
			last.next = null;
		}
		size--;
		return item;
	}
	
	public Item peekFirst(){
		return isEmpty() ? null : first.item;
	}
	
	public Item peekLast(){
		return isEmpty() ? null : last.item;
	}

	public Iterator<Item> iterator() // return an iterator over items in order
										// from front to end
	{
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public void remove() {
            throw new UnsupportedOperationException();
        }
		
		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			if (!hasNext()) throw new java.util.NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

	}

	public static void main(String[] args) // unit testing (optional)
	{
		Deque<String> q = new Deque<>();
		/*q.addFirst("shadab");
		q.addLast("Anoop");
		q.addFirst("Sud");
		Iterator<String> it = q.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		System.out.println(q.isEmpty());
		q.addFirst("shadab");
		System.out.println(q.removeFirst());
		System.out.println("Hello From Deque");
		
	}
}