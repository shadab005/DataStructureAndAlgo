public class Test {

	public static void main(String[] args) {
	  char[] c = new char[10];
	  System.out.println(c[0]);
	  System.out.println("Done");
	  System.out.println(lengthOfLastWord("My Name is SHadab"));
	}
	
    static int getArea(float r){
        int ans = (int) Math.ceil(3.14*r*r);
    	return ans;
    }
    
    public static int lengthOfLastWord(final String A) {
        if(A.trim().isEmpty())
            return 0;       
        return A.split(" ")[A.split(" ").length-1].length();
    }

	
}
