import java.util.TreeSet;

public class LeastGreatestElementOnRight {

	static int[] leastGreatestOnRight(int a[]) {
		int ans[] = new int[a.length];
		TreeSet<Integer> set = new TreeSet<>();
		for(int i=a.length-1;i>=0;i--) {
			Integer x = set.higher(a[i]);
			if(x==null)ans[i]=-1;
			else {
				ans[i]=x;
			}
			set.add(a[i]);
		}
		return ans;
	}
	public static void main(String[] args) {

	    int a[] = { 8, 58, 71, 18, 31, 32, 63, 92,
	                  43, 3, 91, 93, 25, 80, 28 };
	    
	    int ans[] = leastGreatestOnRight(a);
	    for(int x:ans)System.out.println(x+" ");

	}

}
