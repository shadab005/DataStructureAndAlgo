public class POUR1 {

	int a,b,c;
	int minStep = Integer.MAX_VALUE;
	Boolean dp[][];
	POUR1(int a, int b, int c){
		this.a=a;this.b=b;this.c=c;
		dp = new Boolean[a+1][b+1];
	}
	
	public static void main(String[] args) {
		POUR1 p = new POUR1(5,2,3);
        p.printMinStep();	

	}
	
	static int gcd(int a, int b) {
		if(b==0)return a;
		else return gcd(b, a%b);
	}
	
	void printMinStep() {
		if(a<c&&b<c)System.out.println(-1);
		else if(c%gcd(a,b)!=0) {
			System.out.println(-1);
		}
		else {
			if(minSteps(a,b,0)) {
				System.out.println(minStep);
			}else {
				System.out.println("Lol");
			}
			/*for(int i=0;i<=a;i++) {
				for(int j=0;j<=b;j++) {
					System.out.print(dp[i][j]+" ");
				}
				System.out.println();
			}*/
		}
	}

/*
 * Empty first vessel
 * Empty second vessel
 * Fill first vessel
 * Fill second vessel
 * Pour from first vessel to second
 * Pour from second to first
 */

	
	/**
	 * a : Total capacity of first bucket
	 * b : Total capacity of second bucket
	 * @param x : capacity that can be filled in the first vessel
	 * @param y : capacity that can be filled in the second vessel
	 * @return  : Min Step
	 */
	boolean minSteps(int x, int y, int steps){
		System.out.println("State: "+x+" "+y+" steps : " + steps);
		if(a-x==c || b-y==c) { //Total capacity - Vacant capacity = Filled volume 
			minStep = Math.min(steps, minStep);
			return true;
		}
		if(dp[x][y]!=null) {
			return dp[x][y];
		}
		boolean retval=false;
		dp[x][y]=false;
		if (x < a) {// Empty first bucket
			retval = retval || minSteps(a, y, steps + 1);
		}
		if (y < b) {// Empty second bucket
			retval = retval || minSteps(x, b, steps + 1);
		}
		if (x > 0) { // Fill the first bucket
			retval = retval || minSteps(0, y, steps + 1);
		}
		if (y > 0) { // Fill the second bucket
			retval = retval || minSteps(x, 0, steps + 1);
		}
		if (x < a && y > 0) { // Pour from first into second
			if (a - x <= y) { //All content from first can be poured into second
				retval = retval || minSteps(a, y - (a - x), steps + 1);
			} else{
				retval = retval || minSteps(x+y, 0, steps + 1);
			}
		}
		if(y<b && x>0) { //Pour from second into first
			if(b-y <= x) { //All content from second can be poured into first
				retval = retval || minSteps(x-(b-y), b, steps + 1);
			}else {  //Partial content from second can be filled into first so that first can be full
				retval = retval || minSteps(0, y+x, steps + 1);
			}
		}
		dp[x][y]=retval;
		return retval;
	}

}
