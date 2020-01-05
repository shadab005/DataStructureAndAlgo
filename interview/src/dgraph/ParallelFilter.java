package dgraph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;


public class ParallelFilter {

	public static void main(String[] args) {
		
		test1();
		test2();
		
		testParallel1();
		testParallel2();
		
		
		
		
		
	}
	
	private static void testParallel1() {
		Predicate<Integer> p = x->x%2==0;
		List<Integer> a = Arrays.asList(1,2,3,4,5,6);
		System.out.println(filterInParallel(a, p));
		
	}
	
	private static void testParallel2() {
		Predicate<Integer> p2 = x->x>2;
		List<Integer> a2 = Arrays.asList(1,2,3,4,5,6);
		System.out.println(filterInParallel(a2, p2));
		
	}

	private static void test2() {
		Predicate<Integer> p2 = x->x>2;
		List<Integer> a2 = Arrays.asList(1,2,3,4,5,6);
		System.out.println(filter(a2, p2));
		
	}

	private static void test1() {
		Predicate<Integer> p = x->x%2==0;
		List<Integer> a = Arrays.asList(1,2,3,4,5,6);
		System.out.println(filter(a, p));
		
	}

	static public List<Integer> filter(List<Integer> a, Predicate<Integer> p) {
		if(a==null || a.isEmpty()) return Collections.emptyList();
		
		List<Integer> ans = new ArrayList<>();
		for(int i =0; i<a.size();i++) {
			if(p.test(a.get(i))) {
				ans.add(a.get(i));
			}
		}
		return ans;
	}
	
	static public List<Integer> filterInParallel(List<Integer> a, Predicate<Integer> p) {
		if(a==null || a.isEmpty()) return Collections.emptyList();
		ForkJoinPool forkJoinPoolExecutor = new ForkJoinPool();
		Task task = new Task(a, 0, a.size()-1, p);
		return forkJoinPoolExecutor.invoke(task);
	}
	
	static class Task extends RecursiveTask<List<Integer>> {

		private static final long serialVersionUID = 1L;
		private List<Integer> l;
		private int start;
		private int end;
		private  Predicate<Integer> predicate;
		
		private static final int THRESHOLD = 5;
		
		Task(List<Integer> l, int start, int end, Predicate<Integer> predicate){
			this.l = l;
			this.start = start;
			this.end = end;
			this.predicate = predicate;
		} 
		
		@Override
		protected List<Integer> compute() {
			if(end-start<=THRESHOLD) {
				//System.out.println("start="+start+" end =" +end);
				if(l==null || l.isEmpty()) return Collections.emptyList();
				List<Integer> ans = new ArrayList<>();
				for(int i = start; i<=end;i++) {
					if(predicate.test(l.get(i))) {
						ans.add(l.get(i));
					}
				}
				return ans;
			} else {
				int mid = start+(end-start)/2;
				Task left = new Task(l, start, mid-1, predicate);
				left.fork();
				Task right = new Task(l, mid, end, predicate);
				List<Integer> rightResult = right.compute();
				List<Integer> leftResult = left.join();
				List<Integer> ans = new ArrayList<>();
				ans.addAll(leftResult);
				ans.addAll(rightResult);
				return ans;
			}
		}
		
	}

}
