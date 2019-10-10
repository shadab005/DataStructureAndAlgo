package leetcode;

import algo.util.Util;

public class FirstMissingPositive {

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] {2,1}));

	}
	
	static public int firstMissingPositive(int[] a) {
		if(a.length == 0) return 1;
		if(a.length == 1) {
			if(a[0] !=1)return 1;
			else return 2;
		}
        int ans = 1;
        int n = a.length;
        int i = 0, j = a.length - 1;
        while(i<j) {
        	while(i < n && a[i] > 0) i++;
        	while(j >= 0 && a[j] <= 0) j--;
        	if(i<j) {
        		swap(a, i , j);
        	}
        }
       // Util.printArray(a);
        //System.out.println("j="+j);
        if(j<0) return 1;
        //all positive numbers are from 0 to j
        //System.out.println("j="+j);
        
        for(int k = 0 ; k <= j ; k++) {
        	//System.out.println("k="+k+" j="+j);
        	if(Math.abs(a[k])-1<=j && a[Math.abs(a[k])-1]>0) {
        		//System.out.println("a[k] = " + a[k]);
        		a[Math.abs(a[k])-1]*=-1;
        	}
        }
        //Util.printArray(a);
        i = 0;
        while(i<=j) {
        	if(a[i]>0)return i+1;
        	i++;
        }
        return i+1;		
    }

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
