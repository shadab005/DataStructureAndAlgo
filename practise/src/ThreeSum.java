import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(-10, -10, -10));
		//System.out.println(twoSumClosest(a, 0,a.size()-1,5));
		System.out.println(threeSumClosest(a, -5));
	}
	
	public static int threeSumClosest(ArrayList<Integer> a, int sum) {
		a.sort(null);
		int ans = 0;
		int currentSum = 0;
		int minDiff = Math.abs(sum)+Math.abs(a.get(a.size()-1))+Math.abs(a.get(a.size()-2))+1;
		for(int i=0;i<a.size()-2;i++) {
			currentSum=a.get(i)+twoSumClosest(a, i+1, a.size()-1, sum-a.get(i));
			if(minDiff>Math.abs(sum-currentSum)) {
				minDiff = Math.abs(sum-currentSum);
				ans = currentSum;
				if(minDiff==0)break;
			}
		}
		return ans;
	}
	
	//2 4 5 8 9
	//Take input as sorted elements
	public static int twoSumClosest(ArrayList<Integer> a, int i, int j, int sum) {
		int ans = 0;
		int currentSum = 0;
		int minDiff = Math.abs(sum)+Math.abs(a.get(j-1))+Math.abs(a.get(j))+1;
		while(i<j) {
			currentSum = a.get(i)+a.get(j);
			if(currentSum<sum) {
				i++;
			}else {
				j--;
			}
			if(minDiff>Math.abs(sum-currentSum)) {
				minDiff = Math.abs(sum-currentSum);
				ans = currentSum;
				if(minDiff==0)break;
			}
		}
		return ans;
	}
	

}
