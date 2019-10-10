package leetcode;

public class _45_JumpGame_II {

	public static void main(String[] args) {
		System.out.println(jump(new int[] {1,0,1,0}));

	}
	
	public static int jump(int[] a) { 
        if(a.length == 1) return 0;
        int n = a.length;
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

}
