import java.util.Scanner;

public class Pebble {

	public static void main(String[] args) {
		/*int w[]={3,1,8,9,7};
		int n=5;
		int k=4;*/
		Scanner sc = new Scanner(System.in);  
		int N      = sc.nextInt(); 
		int K = sc.nextInt();
		int count = 0;
		int e=0;
		for(int i =0; i< N; i++){
			e=sc.nextInt();
			count=count+e/K;
			if(e%K!=0)count++;
		}
		sc.close();

	/*	int nn = 3 , kk=2;
		int ww[]= {2, 3, 4};*/
		System.out.print((count+1)/2);

	}

}
