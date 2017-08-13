import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class SNGraph {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int i=0;
		while(t-->0){
			int n = in.nextInt();
			int m = in.nextInt();
			int degree[] = new int[n+1];
			while(m-->0){
				degree[in.nextInt()]++;
				degree[in.nextInt()]++;
			}
			/*System.out.println("Printing degree of individual node");
			for(i=0;i<=n;i++){
				System.out.print(degree[i]+" ");
			}
			System.out.println();*/
			long countDegree[] = new long[n];
			for(i=1;i<=n;i++){
				countDegree[degree[i]]++;
			}
			
			/*System.out.println("Printing count of each degree");
			for(i=0;i<n;i++){
				System.out.print(countDegree[i]+" ");
			}
			System.out.println();*/
			for(i=1;i<n;i++){
				if(countDegree[i]+countDegree[i-1]<n)
				countDegree[i]+=countDegree[i-1];
				else break;
			}
			while(i<n){
				countDegree[i]=n-1;
				i++;
			}
			
			/*System.out.println("Printing cumulative count of each degree");
			for(i=0;i<n;i++){
				System.out.print(countDegree[i]+" ");
			}
			System.out.println();*/
			
			for(i=0;i<n;i++){
				System.out.print(countDegree[i]+" ");
			}
			if(t>0)
			System.out.println();
		}
		in.close();
		
		

	}

}
