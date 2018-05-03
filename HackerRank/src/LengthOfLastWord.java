import java.util.ArrayList;

public class LengthOfLastWord {

	public int lengthOfLastWord(final String s) {
       if(s==null || s.length()==0)return 0;
       int n = s.length();
       int i = n-1;
       while(i>=0 && s.charAt(i)==' ')i--;
       n=i+1;
       while(i>=0 && s.charAt(i)!=' ')i--;
	   return n-i-1;
	}
	
	public String reverseWords(String s) {
		if(s==null)return null;
		if(s.isEmpty())return " ";
		ArrayList<String> l = new ArrayList<>();
		int i=0;
		int n = s.length();
		while(i<n) {
			if(s.charAt(i)==' ')i++;
			else {
				int j = i+1;
				while(j< n && s.charAt(j)!= ' ')j++;
				l.add(s.substring(i, j));
				i=j+1;
			}
		}
		int N = l.size();
		StringBuilder ans = new StringBuilder("");
		for(i= N-1;i>=0;i--) {
			ans.append(l.get(i));
			ans.append(' ');
		}
		String answer = ans.toString();
		int z= answer.length();
		//System.out.println(answer.substring(0, z-1)+"zz");
		return  answer.substring(0, z-1);
	}
	
	public static void main(String[] args) {
		System.out.println(new LengthOfLastWord().reverseWords(" the sky is blue "));
		System.out.println("End");

	}

}
