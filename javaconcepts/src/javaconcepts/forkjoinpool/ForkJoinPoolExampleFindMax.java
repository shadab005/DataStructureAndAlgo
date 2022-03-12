package javaconcepts.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExampleFindMax {

	public static void main(String[] args) {
		int a[] = {2,5,6,1,4,8,9,10,11,10,23,-2};
		ForkJoinPool forkJoinPoolExecutor = new ForkJoinPool();
		FindMaxPositionRecursiveTask task = new FindMaxPositionRecursiveTask(a, 0, a.length);
		int ans = forkJoinPoolExecutor.invoke(task);
		System.out.println(ans +" " + a[ans]);

	}

}

class FindMaxPositionRecursiveTask extends RecursiveTask<Integer>
{
	private static final long serialVersionUID = 1L;
	private int a[];
	private int start;
	private int end;

	private static final int THRESHOLD = 3;

	FindMaxPositionRecursiveTask(int a[], int start, int end){
		this.a = a;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		if(end-start<=THRESHOLD) {
			int ans = start;
			int max = a[start];
			for(int i=start+1 ; i<end; i++) {
				if(a[i]>max) {
					max = a[i];
					ans = i;
				}
			}
			return ans;
		}else {
			int mid = start+(end-start)/2;
			FindMaxPositionRecursiveTask left = new FindMaxPositionRecursiveTask(a, start, mid);
			left.fork();
			FindMaxPositionRecursiveTask right = new FindMaxPositionRecursiveTask(a, mid, end);
			int posRight = right.compute();
			int posLeft = left.join();
			if(a[posLeft]>a[posRight])return posLeft;
			else return posRight;

		}
	}

}
