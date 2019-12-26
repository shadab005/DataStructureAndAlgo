package leetcode;

import java.util.List;

public class _120_Triangle {
	
	
	public static void main(String[] args) {
		
	}
	
	
	static public int minimumTotal(List<List<Integer>> triangle) {
		
		int row = triangle.size();
		
		if(row==0) return 0;
		if(row == 1) return triangle.get(0).get(0);
		
		int a[] = new int[triangle.get(row-1).size()]; //create an array of size equal to last row
		//copy last row elements
		for(int j =0 ; j < triangle.get(row-1).size(); j++) {
			a[j] = triangle.get(row-1).get(j);
		}
		for(int i = row-2; i>=0; i--) {
			for(int j = 0; j < triangle.get(i).size() ; j++) {
				a[j] = triangle.get(i).get(j) + Math.min(a[j], a[j+1]);
			}
		}
		return a[0];
    }



}
