import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BathroomStalls {

	static void getGapLeftRight(int n, int k, int caseNumber){
		int z=n/2;
		if(n==k){
			//System.out.println(0+" "+0);
			printOutput(caseNumber, 0, 0);
		}else if(k==1){
			if((n&1)==1){
				//System.out.println(z +" " +z);
				printOutput(caseNumber, z, z);
			}else{
				//System.out.println(z +" " + (z-1));
				printOutput(caseNumber, z, z-1);
			}
		}else{
			int a[]= new int[z+1];
			int lastj=z,lasti=z;
			if((n&1)==1){
				a[z]=2;
				lastj=z;
			}else{
				a[z]=1;
				a[z-1]=1;
				lastj=z-1;
				if(k<=2)lastj=z;
			}
			int count=2;
			int j = 0;
			//System.out.println("z="+z+" lastj="+lastj);
			for (int i = z; i >= 1 && count < k-1; i--) {
				if((i&1)==1){
					j=i/2;
					a[j]=a[j]+a[i]*2;
					lastj=j;
				}else{
					j=i/2;
					a[j]=a[j]+a[i];
					a[j-1]=a[j-1]+a[i];
					lastj=j-1;
				}
				count+=a[i]*2;
				lasti=i;
			}
			/*for(int l=0;l<a.length;l++){
				System.out.print(a[l]+ " ");
			}
			System.out.println();*/
			//lastj=prevj;
			//System.out.println("lastj="+lastj);
			if((lasti&1)==0 && count-a[lasti]>=k-1 && count!=2){
				lastj=lastj+1;
			}
			//System.out.println("lastj="+lastj);
			//System.out.println("lastj="+lastj+" lasti="+lasti+" count="+count);
			if((lastj&1)==1){
				z=lastj/2;
				//System.out.println(z +".." +z);
				printOutput(caseNumber, z, z);
			}else{
				z=lastj/2;
				//System.out.println(z +"##" +(z-1));
				printOutput(caseNumber, z, z-1);
			}
			
		}
	}
	static void printOutput(int caseNumber, int x, int y){
		System.out.println("Case #"+caseNumber+": "+x+" "+y);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1; i <= t; i++){
			//getFlipCount(in.next(),in.next(),i);
			getGapLeftRight(in.nextInt(), in.nextInt(),i);
		}
		in.close();

	}

}
