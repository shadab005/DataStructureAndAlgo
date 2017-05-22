import java.util.Scanner;

public class ClassesSchedule {

	public static void main(String[] args) {
		int max=0;
		Scanner sc = new Scanner(System.in);  
		int n      = sc.nextInt();
		int a[][] = new int [n][2];
		for (int i = 0; i < n; i++) {
			a[i][0]=sc.nextInt();
			a[i][1]=sc.nextInt();
		}
		n=sc.nextInt();
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			x=sc.nextInt();
			y=sc.nextInt();
			for (int j = 0; j < a.length; j++) {
				if(a[j][0]>y){
					max=Math.max(max, a[j][0]-y);
				}else if(x>a[j][1]){
					max=Math.max(max, x-a[j][1]);
				}
			}
		}
		sc.close();
		System.out.print(max);
	    
	   

	}

}
