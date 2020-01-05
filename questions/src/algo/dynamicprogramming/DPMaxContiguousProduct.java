package algo.dynamicprogramming;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DPMaxContiguousProduct {

	public static int maxProduct(List<Integer> a) {
		int maxP = a.get(0);
		int minP = a.get(0);
		int ans = maxP;
		
		for(int i=1;i<a.size();i++) {
			if(a.get(i)>0) {
				maxP = Math.max(a.get(i)*maxP, a.get(i));
				minP = Math.min(a.get(i)*minP, a.get(i));
			}else if(a.get(i)<0){
				ans = Math.max(ans, maxP);
				int temp = maxP;
				maxP = Math.max(minP*a.get(i),a.get(i));
				minP = Math.min(temp*a.get(i), a.get(i));
			}else {
				ans = Math.max(ans, maxP);
				ans = Math.max(ans, 0);
				i++;
				if(i<a.size()) {
					maxP = a.get(i);
					minP = a.get(i);
				}
			}
		}
		ans = Math.max(maxP, ans);
		/*System.out.println("minP = " + minP);
		System.out.println("maxP = " + maxP);
		System.out.println("ans = " + ans);*/
		return ans;
    }
	
    static public int maxProduct(int[] nums) {
        return maxProduct(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
	
	public static void main(String[] args) {
		System.out.println(maxProduct(Arrays.asList(2,3,-2,4)));
		System.out.println(maxProduct(Arrays.asList(1,8,-1,2,2,2,-1)));
		System.out.println(maxProduct(Arrays.asList(2,2,2,2,-1,2,3,-1,2)));

	}

}
