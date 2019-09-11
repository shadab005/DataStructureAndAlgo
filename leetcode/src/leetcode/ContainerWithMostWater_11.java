package leetcode;

public class ContainerWithMostWater_11 {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}

	static public int maxArea(int[] height) {
		int i = 0, j = height.length-1;
		int max = 0;
		while(i<j) {
			max = Math.max(max, Math.min(height[i], height[j])*(j-i));
			if(height[i]>height[j])j--;
			else i++;
		}
		return max;
	}
}
