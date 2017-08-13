import java.util.Scanner;

class SEAVOTE {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
		int n = in.nextInt();
		int min = 100;
		int k = 0;
		int sum=0;
		int x = 0;
		for(int i = 0; i<n;i++){
			x = in.nextInt();
			if(x!=0)k++;
			sum+=x;
		}
		int max=99+k;
		if(sum>=min &&sum<=max){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		}
		in.close();

	}

}
