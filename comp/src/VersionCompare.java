import java.math.BigInteger;

public class VersionCompare {
	
	public static int compareVersion(String s1, String s2) {
        String[] a = s1.split("\\.");
        String[] b = s2.split("\\.");
        int i = 0;
        int j = 0;
        while(i<a.length && j<b.length) {
        	int x = compare(a[i], b[j]);
        	/*if(Integer.parseInt(a[i]) < Integer.parseInt(b[j]))return -1;
        	else if(Integer.parseInt(a[i]) > Integer.parseInt(b[j]))return 1;*/
        	if(x<0)return -1;
        	if(x>0)return 1;
        	i++;
        	j++;
        }
        if(i<a.length && j==b.length) {
        	while(i<a.length && a[i].equals("0"))i++;
        	if(i<a.length)return 1;
        }
        if(i==a.length && j<b.length) {
        	while(j < b.length && b[j].equals("0"))j++;
        	if(j<b.length)return -1;
        }
        return 0;
    }

	public static void main(String[] args) {
		//System.out.println(compareVersion("4444371174137455", "5.168"));
		System.out.println("4444371174137455".compareTo("5"));
		System.out.println((Integer.MIN_VALUE+"").substring(1));

	}
	
	//Integer compare
	private static int compare(String s1, String s2) {
		BigInteger b1 = new BigInteger(s1);
		BigInteger b2 = new BigInteger(s2);
		return b1.compareTo(b2);
	}

}
