import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class CominationSum {

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int k) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> currentList = new ArrayList<>();
		combinationSum(a,k,0,ans,0, currentList);
		for(ArrayList<Integer> x:ans) {
			x.sort(null);
		}
		ans = new ArrayList<>(new HashSet<>(ans));
		Comparator<ArrayList<Integer>> byList = (l1,l2)->{
			int n1 = l1.size();
			int n2 = l2.size();
			int i=0,j=0;
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
	private void combinationSum(ArrayList<Integer> a, int k, int i, ArrayList<ArrayList<Integer>> ans, int currentSum, ArrayList<Integer> currentList) {
		if(currentSum==k) {
			ans.add(new ArrayList<>(currentList));
		}else if(currentSum<k && i<a.size()) {
			combinationSum(a, k, i+1, ans, currentSum, currentList);
			currentList.add(a.get(i));
			combinationSum(a, k, i+1, ans, currentSum+a.get(i), currentList);
			currentList.remove(currentList.size()-1);
		}
	}
	
	public static void main(String[] args) {
		CominationSum solver = new CominationSum();
		int k =33;
		ArrayList<Integer> l = new ArrayList<>(Arrays.asList( 15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17));
		ArrayList<ArrayList<Integer>> ans = solver.combinationSum(l, k);
		//ans = new ArrayList<>(new HashSet<>(ans));
		for(ArrayList<Integer> x:ans) {
			System.out.println(x);
		}
	}

}
