import java.util.Scanner;

class TASHIFT {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String t = in.next();
		String p = in.next();
		p=p+p;
		new TASHIFT().calculateMinShift(t.toCharArray(), p.toCharArray(), n);
		in.close();
	}
	
	void calculateMinShift(char t[], char p[], int n){
		int f[] = new int[2*n];
		int i = 0; int j=0;
		while(i<2*n){
			if(p[i]==t[(j+1)%n]){
				f[i]=(j+1)%n;
				i++;
				j++;
			}else if(j!=0 && j!=f[j-1]){
				j=f[j-1];
			}else{
				j=0;
				f[i]=0;
				i++;
			}
		}
		
		int max = Integer.MIN_VALUE;
		int max_index = -1;
		
		for(i=0;i<n;i++){
			if(max<f[i]){
				max=f[i];
				max_index=i;
			}
		}
		
		
		/*Util.printArray(f);
		System.out.println(max_index+" " + max);
		*/
		System.out.println(max_index-max+1);
		
	}

}
