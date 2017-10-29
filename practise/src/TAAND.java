import java.util.Scanner;

class TAAND {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[]=new int[n];
		int x = 0;
		boolean allEqual=true;
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
			x = x|a[i];
			if(a[0]!=a[i]){
				allEqual=false;
			}
		}
		if(x==0){
			System.out.println(0);
		}else{
		solveMaxAnd(a,n,31,allEqual);
		}
		in.close();

	}
	
	private static void solveMaxAnd(int[] a, int n, int max_bit, boolean allEqual) {
		if(n==2 || allEqual){
			System.out.println(a[0]&a[1]);
			return;
		}
		int count=0;
		int b[] = new int[n];
		boolean equal = true;
		for(int bit=max_bit;bit>=0;bit--){
			equal=true;
			for(int i=0;i<n;i++){
				if((a[i]&(1<<bit))!=0){
					b[count]=a[i];
					count++;
					if(b[0]!=a[i]){
						equal=false;
					}
				}
			}
			if(count>=2){
				solveMaxAnd(b, count, bit-1,equal);
				break;
			}else{
				count=0;
			}
		}
		
	}

	static void solve(int a[], int n){
		int max = -1;
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				if(max<(a[i]&a[j])){
					max=a[i]&a[j];
				}
			}
		}
		System.out.println(max);
	}

}
