
public class LongestIncreasingSubsequence {

	private static int a[] = {12,0,16,17,18,3,2,6,8,1,1,90};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(lic(0,Integer.MIN_VALUE));
		System.out.println(licfromlast(a.length-1,Integer.MAX_VALUE-1));
	}
	
	private static int lic(int i, int value)
	{
		if(i >= a.length) return 0;
		
		if(a[i] >= value)
			return Math.max(1 + lic(i+1,a[i]),lic(i+1,value));
		else
			return lic(i+1,value);
	}
	
	private static int licfromlast(int n, int value)
	{
		if(n <= 0) return 0;
		
		if(a[n] <= value)
			return Math.max(1 + licfromlast(n-1,a[n]),licfromlast(n-1,value));
		else
			return licfromlast(n-1,value);
	}
	

}
