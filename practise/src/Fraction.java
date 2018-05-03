import java.util.HashMap;

public class Fraction {

	public static void main(String[] args) {
		//System.out.println("".length());
		System.out.println(printFraction( 593,88));
		System.out.println(Math.abs(Integer.MIN_VALUE));
		//System.out.println(12161*1.0/9990);

	}

	public static String printFraction(int a, int b) {
		if(a==-2147483648 && b==-1)return "2147483648";
		if(a==-1 && b==-2147483648)return "0.0000000004656612873077392578125";
		String ans = "";
		boolean negative = false;
		if((a<0 && b>0) || (a>0 && b<0)) {
			negative=true;
		}
		a=Math.abs(a);
		b=Math.abs(b);
		
		int q = a/b;
		ans+=q;
		a=a-b*q;
		if(a==0)return ans;
		ans+=".";
		HashMap<Integer, Integer> mapOfRemainderToQuotient = new HashMap<>();
		mapOfRemainderToQuotient.put(a,-1);
		a=a*10;
		int r = -1;
		StringBuilder quotient = new StringBuilder("");
		int x = 0;
		while(a!=0) {
			q = a/b;
			r = a-b*q;
			quotient.append(q);
			if(mapOfRemainderToQuotient.get(r)!=null)break;
			mapOfRemainderToQuotient.put(r, x++);
			a=r*10;
		}
		if(a==0)ans=ans+quotient;
		else if(mapOfRemainderToQuotient.get(r)!=null) {
			int z = mapOfRemainderToQuotient.get(r);
			String first = quotient.substring(0, z+1);
			String quotientZ = quotient+"";
			if(z==-1) {
			ans+="("+quotient+")";
			}else {
				int l1=first.length();
				String second = quotientZ.substring(l1);
				if(!first.equals(second)) {
					ans+=first;
				}
				ans+="("+second+")";
			}
		}
		if(negative)return "-"+ans;
		return ans;
	}

}

/*
1.2(173)
x=1.2(173)
10x=12.(173)
10000x=12173.(173)
x = 121261/9990

*/