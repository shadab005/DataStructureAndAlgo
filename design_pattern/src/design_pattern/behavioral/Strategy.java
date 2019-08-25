package design_pattern.behavioral;

import java.util.List;

/*
 * Strategy pattern allows you to switch the algorithm or strategy based upon the situation.
 */

interface SortStrategy
{
    public void sort(List<Integer> data);
}

class BubbleSortStrategy implements SortStrategy {
	@Override
	public void sort(List<Integer> data) {
		System.out.println("Sorting using BubbleSort");
	}
}

class QuickSortStrategy implements SortStrategy {
	@Override
	public void sort(List<Integer> data) {
		System.out.println("Sorting using QuickSort");
	}
}

class Sorter {
	SortStrategy sortStrategy;
	public Sorter(SortStrategy sortStrategy) {
		this.sortStrategy = sortStrategy;
	}
	void sort(List<Integer> data) {
		sortStrategy.sort(data);
	}
}


public class Strategy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
