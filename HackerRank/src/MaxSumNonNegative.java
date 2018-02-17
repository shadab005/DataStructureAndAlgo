import java.util.ArrayList;

public class MaxSumNonNegative {

	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
		int n = a.size();
		int maxI = 0, maxJ = 0;
		long  maxSum = 0;
		int i = 0;
		while(i<n && a.get(i) < 0) i++;
		if(i==n)return new ArrayList<>();
		maxI = i; 
		maxJ = i;
		maxSum = a.get(i);
		int j;
		long sum = maxSum;
		j = i+1;

		while(j<n) {
		   if(a.get(j)<0) {
			   j--;
			   if(maxSum<sum) {
				   maxI = i;
				   maxJ = j;
				   maxSum = sum;
			   }else if(maxSum==sum) {
				   if(j-i>maxJ-maxI) {
					   maxI = i;
					   maxJ = j;
				   }
			   }
			   sum = 0;
			   i = j+2;
			   while(i<n && a.get(i)<0)i++;
			   j = i;
		   }else {
			   sum+=a.get(j);
			   j++;
		   }
		}
		//System.out.println("j=="+j+" n=="+n+" (j-1)th element = " + a.get(j-1));
		if(j==n && a.get(j-1)>=0 && sum>=maxSum) {
			//System.out.println("here");
			j--;
			if(maxSum<sum) {
				   maxI = i;
				   maxJ = j;
				   maxSum = sum;
			}else if(maxSum==sum) {
				   if(j-i>maxJ-maxI) {
					   maxI = i;
					   maxJ = j;
				   }
			 }
		}
		
		//System.out.println("maxStart = " + maxI +" maxEnd = " + maxJ  + " maxSum = " + maxSum);
		ArrayList<Integer> o = new ArrayList<>();
		for( i = maxI; i<=maxJ;i++)o.add(a.get(i));
		return o;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<>();
		//1, 2, 5, -7, 2, 5
		a.add(1);
		a.add(2);
		a.add(5);
		a.add(-7);
		a.add(2);
		a.add(5);

		System.out.println(maxset(a));
	}

}
