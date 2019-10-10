package leetcode;

public class _42_TrappingRainWater {

	public static void main(String[] args) {
		System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

	}
	
	static public int trap(int[] h) {
		int n = h.length;
		if(n <= 2) return 0;
		int i = 0, j = n -1;
		int total = 0;
		int lMax = h[i], rMax = h[j];
		while(i<=j) {
			if(lMax < rMax) {
			//	System.out.println("Filling above i = " + i + " and quantity = " + Math.max(lMax - h[i], 0));
				total+= Math.max(lMax - h[i], 0);
				lMax = Math.max(lMax, h[i]);
				i++;
			} else {
				//System.out.println("Filling above j = " + j + " and quantity = " + Math.max(rMax - h[j], 0));
				total+= Math.max(rMax - h[j], 0);
				rMax = Math.max(rMax, h[j]);
				j--;
			}
		}
		return total;
    }

}
