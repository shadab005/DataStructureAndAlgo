package leetcode;

public class _1094_CarPooling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static public boolean carPooling(int[][] trips, int capacity) {
     
		int p[] = new int[1001];
		
		int current = 0;
		for(int i = 0 ; i < trips.length; i++) {
			p[trips[i][1]] += trips[i][0];
			p[trips[i][2]] -= trips[i][0];
		}
		
		for(int i = 0; i< p.length;i++) {
			current+= p[i];
			if(current > capacity) return false;
		}
		return true;
    }

}
