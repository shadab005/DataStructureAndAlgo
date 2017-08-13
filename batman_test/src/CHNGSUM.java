import java.util.Scanner;

class CHNGSUM {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int i,j=0;
		int a[] = new int[n];
		int mod=1000000007;
		for(i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		
		long min[][] = new long[n][n];
		long max[][] = new long[n][n];
		min[0][0]=a[0];
		max[0][0]=a[0];
		for(i=0;i<n;i++){
			for(j=i;j<n;j++){
				if(i==j){
					min[i][j]=a[i];
					max[i][j]=a[i];
				}else{
					if(a[j]<min[i][j-1])min[i][j]=a[j];
					else min[i][j]=min[i][j-1];
					
					if(a[j]>max[i][j-1])max[i][j]=a[j];
					else max[i][j]=max[i][j-1];
				}
			}
		}
		
		/*System.out.println("Min Array");
		Util.printArray(min);
		System.out.println("Max Array");
		Util.printArray(max);*/
		
		boolean done = false;
		long prev = 0;
		i = n-1;
		while(!done)
		{
			j = n-1;
			while(j>=i){
				min[i][j] = min[i][j]+prev;
				prev = min[i][j];
				if(i==0 && j==0)done = true;
				j--;
			}
			i--;
		}
		//System.out.println("Cuulative Min Array");
		//Util.printArray(min);
		
		long sum  = 0;
		for(i=0;i<=n-1;i++){
			for(j=i;j<=n-2;j++){
				//System.out.println("Multiplying i*j="+i+"*"+j+"="  +min[i][j] + "*" + max[j+1][j+1]);
				sum+=max[i][j]*min[j+1][j+1];
				sum=sum%mod;
			}
		}
		//System.out.println("Answer");
		System.out.println(sum%mod);
		in.close();

	}

}
