package datastructure.queue;

public class QueueTest {

	public static void main(String args[]){
		MaxPQ<Integer> maxpq = new MaxPQ<>(7);
		maxpq.insert(7);
		maxpq.insert(3);
		maxpq.insert(5);
		maxpq.insert(8);
		maxpq.printHeap();
		maxpq.delMax();
		maxpq.insert(12);
		maxpq.printHeap();
	}
}
