package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _295_MedianFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFinder m = new MedianFinder();
		m.addNum(1);
		m.addNum(2);
		System.out.println(m.findMedian());
		m.addNum(3); 
		System.out.println(m.findMedian());

	}

	static class MedianFinder {

		PriorityQueue<Integer> minPQ;
		PriorityQueue<Integer> maxPQ;

		public MedianFinder() {
			minPQ = new PriorityQueue<>(Integer::compareTo);
			maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
		}

		public void addNum(int n) {
			if(maxPQ.isEmpty()) maxPQ.add(n);
			else {
				if(maxPQ.peek() < n) minPQ.add(n);
				else maxPQ.add(n);
				
				if(maxPQ.size() - minPQ.size() > 1) {
					balanceElement(maxPQ, minPQ);
				} else if(minPQ.size() - maxPQ.size() > 1) {
					balanceElement(minPQ, maxPQ);
				}
			}

		}

		private void balanceElement(PriorityQueue<Integer> fromPQ, PriorityQueue<Integer> toPQ) {
			toPQ.add(fromPQ.remove());
		}

		public double findMedian() {
			if (minPQ.size() == maxPQ.size() && !minPQ.isEmpty()) {
				return ((double)minPQ.peek() + (double)maxPQ.peek() )/ 2.0;
			} else if (maxPQ.size() > minPQ.size()) {
				return maxPQ.peek();
			} else if (minPQ.size() > maxPQ.size()) {
				return minPQ.peek();
			}
			return -1;
		}
	}

}
