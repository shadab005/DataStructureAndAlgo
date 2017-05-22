import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;

class TheNextPallindrome {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int w = 1; w <= t; w++) {
			String s = in.next();
			char c[] = s.toCharArray();
			int n = c.length;
			int i = n / 2 - 1;
			int j = n - i - 1;
			boolean solved = false;
			int probable = -1;
			if((n&1)==1 && c[n/2]!='9')probable=n/2;
			boolean allequal=true;
			while (!solved && i >= 0) {
				if(c[i]<c[j]){
					allequal=false;
					if(probable!=-1){
						c[j]=c[i];
						c[probable]=(char) (c[probable]+1);
						c[n-probable-1]=c[probable];
						int qq=probable+1;
						int r = n-qq-1;
						if(c[probable]=='9')probable=-1;
						while(qq<=r){
							probable=qq;
							c[qq]='0';
							c[r]='0';
							qq++;
							r--;
						}
						if(probable==-1){
							qq=probable-1;
							while(qq>=i){
								if(c[qq]!='9'){
									probable=qq;
									break;
								}
								qq--;
							}
						}
						i=i-1;
						j=j+1;
						while(i>=0 && j<n){
							c[j]=c[i];
							i--;
							j++;
						}
						solved=true;
					}else{
						allequal=false;
						c[i]=(char) (c[i]+1);
						c[j]=c[i];
						int q = i+1;
						int r = j-1;
						if(probable==-1 && c[i]!='9')probable=i;
						while(q<=r){
							probable=q;
							c[q]='0';
							c[r]='0';
							q++;
							r--;
						}
						i--;j++;
						while(i>=0 && j<n){
							c[j]=c[i];
							i--;j++;
						}
						solved=true;
						//if(c[q-1]!='9')probable=q-1;
					}
				}else if(c[i]>c[j]){
					allequal=false;
					c[j]=c[i];
					if(probable==-1 && c[i]!='9')probable=i;
					i--;
					j++;
					while(i>=0 && j<n){
						c[j]=c[i];
						i--;j++;
					}
					solved=true;
				}else{
					if(probable==-1 && c[i]!='9')probable=i;
					i--;
					j++;
				}

			}
			if(!allequal)System.out.println(c);
			else{
				if(probable!=-1){
					c[probable]=(char) (c[probable]+1);
					c[n-probable-1]=c[probable];
					int q=probable+1;
					int r=n-q-1;
					while(q<=r){
						c[q]='0';
						c[r]='0';
						q++;
						r--;
					}
					System.out.println(c);
				}else{
					System.out.println("1"+String.join("", Collections.nCopies(n-1, "0"))+"1");
				}
			}
		}
		in.close();

	}

}