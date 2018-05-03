import java.math.BigInteger;

public class Atoi {

	/*
	 * 0-9 =~ 48-57
	 */
	public static int atoi(final String s) {
        if(s.length()==0)return 0;
        char[] c = s.toCharArray();
        int i=0;
        while(i<c.length && c[i]==' ')i++;
        if(i==c.length)return 0;
        if(c[i]=='+' || c[i]=='-')i++;
        if(i==c.length)return 0;
        if(c[i]<'0' || c[i]>'9')return 0;
        int j = i;
        while(j<c.length && (c[j]>= '0' && c[j]<= '9'))j++;
        j--;
        boolean negative = false;
        if(i>0 && c[i-1]=='-')negative=true;
        String num = s.substring(i, j+1);
        if(negative && compare(num, (Integer.MIN_VALUE+"").substring(1))>0)return Integer.MIN_VALUE;
        if(compare(num, Integer.MAX_VALUE+"")>0)return Integer.MAX_VALUE;
        if(negative) return -1*Integer.parseInt(num);
        return Integer.parseInt(num);
	}
	public static void main(String[] args) {
		System.out.println(atoi("   9b 2704"));
		String s = "abcd";
		new StringBuilder(s).reverse().toString();
	}
	
	
	//Integer compare
	private static int compare(String s1, String s2) {
		BigInteger b1 = new BigInteger(s1);
		BigInteger b2 = new BigInteger(s2);
		return b1.compareTo(b2);
	}

}
