import java.util.ArrayList;
import java.util.Comparator;

public class Combination {

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> current = new ArrayList<>();
		int z = 1,count=0;
		combine(ans,n,k,current,z,count);
		for(ArrayList<Integer> x:ans) {
			x.sort(null);
		}
		//ans = new ArrayList<>(new HashSet<>(ans));
		Comparator<ArrayList<Integer>> byList = (l1,l2)->{
			int n1 = l1.size();
			int n2 = l2.size();
			int j=0;
			int i=0;
			while(i<n1 && j<n2) {
				if(l1.get(i)<l2.get(j))return -1;
				else if(l1.get(i)>l2.get(j))return 1;
				i++;
				j++;
			}
			if(i<n1)return 1;
			else if(j<n2)return -1;
			return 0;
		};
		ans.sort(byList);
		return ans;
	}
	private void combine(ArrayList<ArrayList<Integer>> ans,int n, int k, ArrayList<Integer> current, int i, int count) {
		if(count==k) {
			ans.add(new ArrayList<>(current));
		}else if(count<k && i<=n) {
			combine(ans, n, k, current, i+1, count);
			current.add(i);
			combine(ans, n, k, current, i+1, count+1);
			current.remove(current.size()-1);
		}
	}
	public static void main(String[] args) {
		Combination solver = new Combination();
		int k =2,n=4;
		ArrayList<ArrayList<Integer>> ans = solver.combine(n, k);
		for(ArrayList<Integer> x:ans) {
			System.out.println(x);
		}

	}

}
