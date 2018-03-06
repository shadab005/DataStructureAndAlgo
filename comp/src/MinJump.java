public class MinJump {

	public static int minStep(int[] a, int n) {
		int minIndexToJump[]  = new int[n];
		int i = 0;
		for(int j=1;j<n;j++){
			while(i+a[i]<j && i<j)i++;
			if(i>=j) return -1;
			else minIndexToJump[j]=i;
		}
		int count=1;
		int j=n-1;
		while(minIndexToJump[j]!=0){
			j=minIndexToJump[j];
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	
	static void test1() {
		int a[] = {23,1,1};
		System.out.println(minJump(a) + " " + minStep(a, a.length));
	}
	
    static void test2() {
    	int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(minJump(a) + " " + minStep(a, a.length));
   }
    static void test3() {
    	int a[] = {
				33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0,
				4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 
				49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0,
				1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48,
				44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 
				0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28
		};
    	System.out.println(minJump(a) + " " + minStep(a, a.length));
    }
	
    static void test4() {
    	int a[] = {
    			9, 0, 0, 22, 0, 0, 39, 11, 3, 0, 0, 24
    			//, 1, 0, 50, 23, 3, 44, 0, 23, 2
    		/*	8, 20, 35, 0, 40, 34, 26, 36, 0, 35, 19, 20, 18, 11, 43, 19, 21, 40, 0,
    			14, 0, 14, 0, 0, 25, 35, 24, 49, 15, 13, 3, 0, 10, 31, 25, 27, 37, 27, 
    			43, 44, 27, 8, 43, 0, 0, 33, 25, 19, 47, 0, 29, 5, 2, 12, 8, 7, 0, 16, 
    			36, 0, 6, 17, 35, 36, 21, 0, 9, 1, 0, 43, 29, 39, 15, 18, 0, 34, 26, 48,
    			0, 34, 35, 7, 10, 0, 0, 15, 5, 12, 26, 0, 37, 30, 33, 27, 34, 9, 37, 22,
    			0, 0, 24, 30, 0, 0, 38, 23, 25, 0, 30, 39, 24, 31, 0, 6, 19, 25, 0, 28,
    			15, 8, 0, 48, 0, 35, 41, 0, 24, 1, 41, 31, 0, 35, 21, 15, 26, 15, 27, 
    			4, 0, 8, 4, 0, 0, 2, 42, 18, 0, 28, 18, 49, 34, 5, 10, 41, 48, 26, 14,
    			45, 44, 9, 0, 49, 50, 24, 0, 0, 0, 23, 0, 17, 0, 47, 31, 0, 42, 0, 0, 0,
    			40, 46, 22, 50, 32, 20, 3, 44, 22, 0, 37, 25, 0, 19, 26, 14, 23, 27, 41, 0,
    			1, 13, 0, 48, 20, 37, 8, 0, 18, 0, 26, 12, 19, 32, 19, 22, 0, 0, 0, 0, 0, 16,
    			0, 0, 43, 0, 10, 5, 0, 6, 26, 0, 24, 40, 29, 0, 43, 18, 27, 0, 0, 37, 0, 46, 
    			35, 17, 0, 20, 44, 29, 29, 40, 33, 22, 27, 0, 0, 38, 21, 4, 0, 0, 15, 31, 48, 
    			36, 10, 0, 41, 0, 45, 39, 0, 11, 9, 3, 38, 16, 0, 11, 22, 37, 0, 3, 44, 10, 12,
    			47, 22, 32, 7, 24, 1, 0, 22, 25, 0, 14, 0, 0, 0, 23, 0, 36, 1, 42, 46, 0, 48, 0,
    			33, 5, 27, 45, 0, 15, 29, 0, 50, 2, 31, 25, 6, 36, 19, 10, 23, 0, 37, 4, 1, 7, 
    			12, 0, 0, 49*/
		};
    	System.out.println(minJump(a) + " " + minStep(a, a.length));
    }
	
    
	public static int minJump(int a[]) {
		int n = a.length;
		if(n<=1)return 0;
		if(a[0]==0)return -1;
		int step = 1;
		int max = a[0];
		int curMax = a[0];
		for(int i=0;i<=max;i++) {
			if(i==n-1)return step;
			curMax = Math.max(curMax, i+a[i]);
			if(i==max) {
				if(curMax<=i)return -1;
				max = curMax;
				step++;
			}
		}
		return -1;
	}
	
	public static int minJump(int[] a, int n) {
		if(a[0]==0)return -1;
		int count = 0;
		int i = 0;
		while(i+a[i] < n-1) {
			//System.out.println("Solving for i = " + i);
			i = getMax(a, i+1, i+a[i]);
			//System.out.println("Next index to jump = " + i);
			if(a[i]==0)return -1;
			count++;
			//System.out.println("count = " + count);
		}
		return count+1;
	}

	private static int getMax(int[] a, int i, int j) {
		int max = -1, maxIndex = 0;
		max = i+a[i];
		maxIndex = i;
		for(int k = i+1 ; k<=j ;k++) {
			if(max < a[k]+k) {
				max = a[k]+k;
				maxIndex = k;
			}
		}
		return maxIndex;
	}
}

