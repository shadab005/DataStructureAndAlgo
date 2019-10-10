package amazon;

public class ForumKLimit {

	public static void main(String[] args) {
		System.out.println(solution("abc de", 5));

	}

	static public String solution(String s, int k) {
		if(s.length()<=k)return s;
		
		String sub = s.substring(0, k);
		if(s.charAt(k)== ' ') {
			return sub;
		}
		int lastIndexOfSpace = sub.lastIndexOf(' ');
		return sub.substring(0, lastIndexOfSpace);
	}
	
}
