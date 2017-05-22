import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class MinStep {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new java.io.BufferedReader(new InputStreamReader (System.in));
		String s = br.readLine();
		int denominator=1000000007;
		int last=s.length()-1;
		int prev=-1;
		BigInteger prevCount=new BigInteger("0");
		long countB=0;
		BigInteger m = new BigInteger("0");
		
		int k = 0;
		
		long steps = 0;
		BigInteger ss = new BigInteger("0");
		BigInteger K = new BigInteger("2");
		BigInteger one = new BigInteger("1");
		BigInteger den = new BigInteger("1000000007");
		boolean flag=false;
		while(last>=0){
			//System.out.println("last="+last);
			if(s.charAt(last)=='b'){
				flag=true;
				countB++;
			}else if(flag){
				m=new BigInteger(countB+"");
				if(last+countB+1==prev){
					//m=m+prevCount;
					m=m.add(prevCount);
				}
				k=countA(s,last);
				last=last-k+1;
				ss = K.pow(k).subtract(one).multiply(m);
				//ss = ((Math.pow(2, k)-1)*m);
				steps = (Integer.parseInt(ss.mod(den).toString())+steps)%denominator;
				//steps=(long) (steps%denominator+ss%denominator);
				//System.out.println(steps);
				//System.out.println(ss);
				prev=last;
				prevCount=ss.add(m);
				countB=0;
				flag=false;
			}
			last--;
		}
		System.out.println(steps%denominator);
	}

	//aaaaabaabababaaaaaba
//abaaaaaabaaaabbabbaaabbbbabababaaaaabbaabbaaaaabbbaababaaaaaaabbbbbaaaaabaababbabababbabbbbaabbaabbabbbabaabbaabbaaaaaab


	static int countA(String s, int i){
		int last=i;
		while(i>=0 && s.charAt(i)=='a'){
			i--;
		}
		if(i<0)return last+1;
		return last-i;
	}

}
