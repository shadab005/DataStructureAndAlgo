import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] items;
	private int size, head = -1, tail = -1;
	private int n = 2;

	public RandomizedQueue() // construct an empty randomized queue
	{
		items = (Item[]) new Object[n];
	}

	public boolean isEmpty() // is the queue empty?
	{
		return size == 0;
	}

	public int size() // return the number of items on the queue
	{
		return size;
	}

	public void enqueue(Item item) // add the item at tail
	{
		if (item == null)
			throw new java.lang.NullPointerException();
		if (isEmpty()) {
			head = 0;
			tail = -1;
		} else if (size == n) {
			resize(items.length * 2);
		}
		tail = (tail + 1) % n;
		items[tail] = item;
		size++;
		int rand = (head + StdRandom.uniform(size)) % n;
		Item temp = items[rand];
		items[rand] = items[tail];
		items[tail] = temp;
	}

	public Item dequeue() // remove item from head and return item
	{
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		Item item = items[head];
		items[head] = null;
		head = (head + 1) % n;
		size--;
		if (size > 0 && size == items.length / 4)
			resize(items.length / 2);
		return item;
	}

	// resize the underlying array holding the elements
	private void resize(int capacity) { // called when the size of array gets
										// full
		assert capacity >= size;
		Item[] temp = (Item[]) new Object[capacity];
		int k = 0;
		while (head != tail) {
			temp[k++] = items[head];
			head = (head + 1) % n;
		}
		temp[k++] = items[head];
		size = k;
		n = capacity;
		head = 0;
		tail = size-1;
		items=temp;
	}

	public Item sample() // return (but do not remove) a random item
	{
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		int rand = StdRandom.uniform(size);
		return items[(head + rand) % n];
	}

	public Iterator<Item> iterator() // return an independent iterator over items in random order
	{
		return new RandomQueueIterator();
	}

	private class RandomQueueIterator implements Iterator<Item> {
        private int i;
        private int queueSize;

        public RandomQueueIterator() {
            i = head;
            queueSize=size;
        }

        public boolean hasNext() {
            return queueSize!=0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            Item item = items[i];
            i=(i+1)%n;
            queueSize--;
            return item;
        }
    }
	
	public static void main(String[] args) // unit testing (optional)
	{
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		for (int i = 0; i <= 5; i++) rq.enqueue(i);
		for (Integer i : rq) System.out.print(i + " ");
	}
}