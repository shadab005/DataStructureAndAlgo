import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TeaParty {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();
		int w = in.nextInt();
		int a[] = new int[n];
		Integer b[] = new Integer[n];
		int c[] = new int[n];
		int min = 100;
		int sumRemainingCapacity=0;
		for (int i = 0; i < n && w>=0; i++) {
			b[i]=i;
			a[i] = in.nextInt();
			int halfCapacity = (a[i]+1)/2; 
			w=w-halfCapacity; //deducting
			c[i]=halfCapacity; //pouring
			sumRemainingCapacity += a[i]-halfCapacity; //remaining
			if (min > a[i]) {
				min = a[i];
			}
		}
		if(w<0 || sumRemainingCapacity < w){
			System.out.println(-1);
		}else{
			//w is remaining tea in tea pot which should be porured completely
			Arrays.sort(b, new Comparator<Integer>() {
				public int compare(Integer i, Integer j){
					return a[j]-a[i];
				}
			});
			int remaining = a[b[0]]-c[b[0]];
			if(remaining>=w){
				c[b[0]]+=w;
				w=0;
			}else{
				c[b[0]]+=remaining;
				w=w-remaining;
			}
			for(int i=1;i<n && w>0;i++){
				remaining = a[b[i]]-c[b[i]];
				int maxCanbeFilled = c[b[i-1]]-c[b[i]];
				if(maxCanbeFilled>0){
					if(remaining>=w){
						//To be filled w
						if(w<=maxCanbeFilled){
							c[b[i]]+=w;
							w=0;
						}else{
							c[b[i]]+=maxCanbeFilled;
							w=w-maxCanbeFilled;
						}
					}else{
						//To be filled is remaining
						if(remaining<=maxCanbeFilled){
							c[b[i]]+=remaining;
							w=w-remaining;
						}else{
							c[b[i]]+=maxCanbeFilled;
							w=w-maxCanbeFilled;
						}
					}
				}
			}
			if(w!=0){
				System.out.println(-1);
			}else{
				printArray(c);
			}
		}
		in.close();

	}
	public static void printArray(int a[]){
		for(int i = 0 ; i< a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
}
