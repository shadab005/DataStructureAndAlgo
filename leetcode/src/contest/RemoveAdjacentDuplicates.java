package contest;

public class RemoveAdjacentDuplicates {

	public static void main(String[] args) {
		System.out.println(removeDuplicates("deeedbbcccbdaa", 3));

	}
	
	static public String removeDuplicates(String s, int k) {
      String ans = "";
      ans = splitJoin(s, k);
      return ans;
    }

	private static String splitJoin(String s, int k) {
		if(s.length()<k) return s;
		int n = s.length();
		String left = splitJoin(s.substring(0, n/2+1), k);
		String right = splitJoin(s.substring(n/2), k);
		return join(left,right,k);
	}

	private static String join(String left, String right, int k) {
		System.out.println("Checking left= "+left+ " right= " + right);
		int n1 = left.length();
		int n2 = right.length();
		if(n1>=2 && left.charAt(n1-1) == left.charAt(n1-2)) {
			if(n2>0 && right.charAt(0) == left.charAt(n1-1)) {
				return left.substring(0, n1-2)+right.substring(1);
			}
		}
		if(n2>=2 && right.charAt(n2-1) == right.charAt(n2-2)) {
			if(n1>0 && left.charAt(0) == right.charAt(n2-1)) {
				return left.substring(1)+right.substring(0,n2-2);
			}
		}
		return left+right;
	}

}
