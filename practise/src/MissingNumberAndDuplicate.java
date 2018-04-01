import algo.util.Util;

public class MissingNumberAndDuplicate {

	
	public static int[] repeatedNumber(final int[] a) {
      int ans[] = new int[2];
	  int n = a.length;
	  int xor = 0;
	  for(int i=1;i<=n;i++) {
		  xor=xor^a[i-1];
		  xor=xor^i;
	  }
	 // System.out.println(xor);
	  int x = xor;
	  x = x^(x-1);
	  x = x+1;
	  x=x>>1;
	  //System.out.println(x);
	  
	  int y = 0;
	  int z = 0;
	  for(int i=1;i<=n;i++) {
		  if((a[i-1]&x)!=0) {
			  y = y^a[i-1];
		  }else {
			  z = z^a[i-1];
		  }
		  if((i&x)!=0) {
			  y = y^i;
		  }else {
			  z = z^i;
		  }
	  }
	 // System.out.println(y+" , " + z);
      boolean found = false;
	  for(int i=0;i<n&&!found;i++) {
		  if(y==a[i])found=true;
	  }
	  if(found) {
		  ans[0]=y;
		  ans[1]=z;
	  }else {
		  ans[0]=z;
		  ans[1]=y;
	  }
      return ans;
	}
	
	public static void main(String[] args) {
		int ans[] = repeatedNumber(new int[] {3,1,2,5,3});
		Util.printArray(ans);

	}

}
