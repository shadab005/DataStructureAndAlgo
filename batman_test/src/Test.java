import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class Test{

	public static void main(String args[]) throws Exception {
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1==s2);
        System.out.println(s1.intern() == s2.intern());

        
        String s = "abc";
        String s3 = new String(s);
        System.out.println(s.hashCode());
        System.out.println(s3.hashCode());
        
    }
	
	public int[] solve(int[] a, int[] b) {
		int n = a.length;
		Arrays.sort(a);
		Arrays.sort(b);
		
		int ans[] = new int[n];
		
		int i=n-1;
		int j = n-1;
		int k = 0;
		while(k!=n-1) {
			ans[k]=a[i]+b[j];
			if(a[i-1]+b[j]>a[i]+b[j-1]) {
				i--;
			}else {
				j--;
			}
			k++;
		}
		return ans;
	}
	
}
