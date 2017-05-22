package datastructure.queue;

public class MaxPQ<Key extends Comparable<Key>> 
{
	private Key[] pq;
	public int count;
	
	@SuppressWarnings("unchecked")
	public MaxPQ(int n)
	{
		pq = (Key[]) new Comparable[n];
	}
	
	public boolean isEmpty()
	{
		return count==0;
	}
	public void insert(Key key)
	{
		pq[count] = key;
		swim(count);
		count++;
	}
	public Key delMax()
	{
		Key max = pq[0];
		swap(0,count-1);
		count--;
		sink(0);
		pq[count] = null;
		return max;
	}
	private void swim(int k)
	{
		while(k > 0 && less((k-1)/2,k))
		{
			swap((k-1)/2, k);
			k = (k-1)/2;
		}
	}
	private void sink(int k)
	{
		while(k < (count-1)/2 )
		{
			int j = 2*k+1;
			if(j < count-1 && less(j,j+1)) j++;
			if(!less(k,j)) break;
			swap(k, j);
			k = j;
		}
	}
	private boolean less(int i, int j){
		return pq[i].compareTo(pq[j]) < 0 ;
	}
	private void swap(int i, int j)
	{
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	public void printHeap()
	{
		int i = 0;
		int level = 1;
		while(i<=count-1){ 
			if( i== level-1){
				System.out.println();
				level = level*2;			
			}
			System.out.print(pq[i]+ " ");
			i++;
		}
		System.out.println();	
	}
	
}
