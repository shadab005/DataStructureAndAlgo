public class Test {

	public static void main(String[] args) {
        System.out.println(Long.toBinaryString(reverse(5)));
	}

	public static long reverse(long n) {
		long x = 0;
		long ans = 0;
		for(int i = 0;i<=31;i++) {
			x = (n&(1<<i));
			ans=ans<<1;
			if(x!=0) {
				ans=ans|1;
			}else {
				ans=ans|0;
			}
		}
		return ans;
	}

}
