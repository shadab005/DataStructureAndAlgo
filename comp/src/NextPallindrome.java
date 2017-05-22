import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

class NextPallindrome {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int w=1;w<=t;w++){
			String s=in.next();
			//System.out.println(s);
			char c[] = s.toCharArray();
			//System.out.println(c);
			int n = c.length;
			//if((n&1)==0){//even length
			int i=n/2-1;
			int j = n-i-1;
			int k=-1;
			//System.out.println("i="+i+" j="+j);
			boolean solved=false;
			boolean allequal=true;
			int probable=-1;
			while(!solved && i>=0){
				if(k==-1 && c[i]!='9')k=i;
				if(c[i]<c[j]){
					//System.out.println("here i="+i+" j="+j);
					allequal=false;
					c[i]=(char) (c[i]+1);
					c[j]=c[i];
					int q = i+1;
					int r = j-1;
					System.out.println("sdljsdl");
					if(probable!=-1){
						c[j]=c[i];
						i--;
						j++;
					}else{
					while(q<=r){
						c[q]='0';
						c[r]='0';
						q++;
						r--;
					}
					solved=true;
					}
				}else if(c[i]>c[j]){
					//System.out.println("there i="+i+" j="+j);
					allequal=false;
					c[j]=c[i];
					while(i>=0 && j<n){
						c[j]=c[i];
						i--;
						j++;
					}
					solved=true;
				}else{
					if(probable==-1 && c[i]!='9')probable=i;
					i--;
					j++;
				}
			}
			if(!allequal){
				//System.out.println("lol");
				//if((n&1)==1)c[n/2]='0';
				System.out.println(c);
			}else{
				//System.out.println("lollzz");
				if((n&1)==1 && c[n/2]!='9'){
					c[n/2]=(char) (c[n/2]+1);
					System.out.println(c);
				}
				else if(k!=-1){
					System.out.println("zzzzzzz ");
					j=n-k-1;
					c[k]=(char) (c[k]+1);
					c[j]=c[k];
					i=k+1;
					j=j--;
					while(i<=j){
						c[i]='0';
						c[j]='0';
						i++;
						j--;
					}
					System.out.println(c);
				}else{
					BigInteger bg = new BigInteger(s);
					//int z=Integer.parseInt(s);
					System.out.println(bg);
				}
			}
		}
		in.close();


	}

}