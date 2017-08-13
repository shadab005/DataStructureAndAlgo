class PairWiseAndSum {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5 };
		int n = 5;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				ans = ans + (a[i] & a[j]);
			}
		}
		int sum = a[0];
		for (int i = 1; i < n; i++) {
			ans = ans + (sum & a[i]);
			sum += a[i];
		}
		System.out.println(ans + " " + sum);

		
		int z = (1 & 5) + (2 & 5) ;
		int zz = ((1+2)&5) + ((1&2)&5);
		System.out.println("z=" + z);
		System.out.println("zz=" + zz);
		System.out.println(1&2&5);
		System.out.println(((1&2)&5));

	}

}
