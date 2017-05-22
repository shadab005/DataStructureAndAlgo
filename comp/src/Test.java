import java.math.BigInteger;
import java.util.Scanner;

public class Test {

	/*
	 * n k
	 * w1 w2 .. wn
	 * 
	 * 5 4
	 * 3 1 8 9 7
	 */

	static int minDays(int w[], int n, int k){
		int count=0;
		for(int i = 0; i<n ;){
			int x = w[i]-k;
			if(x<=0){
				if(i<n-1){
					int y = w[i+1]-k;
					if(y>0){
						w[i+1]=y;
						//i++;
					}else{
						i++;
					}
				}
				i++;
			}else{
				x=x-k;
				if(x<0){
					i++;
				}else{
					w[i]=x;
				}
			}
			count++;

		}

		return count;
	}
	static int md(int w[], int n, int k){
		int q=0;
		int count=0;
		for(int i = 0; i < n; i++){
			q=w[i]/k;
			count+=q;
			if(w[i]%k!=0)count++;
		}
		return (count+1)/2;
	}
	public static void main(String[] args) {
		String s = "99999999999999999999999999999999999999999999999999999999999999999999999999";
		BigInteger bg = new BigInteger(s);
		System.out.println(bg);
	}

}
