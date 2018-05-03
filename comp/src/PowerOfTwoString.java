import java.math.BigInteger;

public class PowerOfTwoString {

	public static int power(String s) {
		if(s.equals("1"))return 0;
         BigInteger b = new BigInteger(s);
         BigInteger bb = b.subtract(new BigInteger("1"));
         if(bb.and(b).toString().equals("0"))return 1;
		 return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(power("128"));

	}

}
