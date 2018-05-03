import java.util.ArrayList;
import java.util.Comparator;

public class PallindromePartitioning {

	
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		ArrayList<String> l = new ArrayList<>();
		partition(ans,s,l);
		Comparator<ArrayList<String>> byList = (l1,l2)->{
			int n1 = l1.size();
			int n2 = l2.size();
			int j=0;
			int i=0;
			while(i<n1 && j<n2) {
				if(l1.get(i).length()<l2.get(j).length())return -1;
				else if(l1.get(i).length()>l2.get(j).length())return 1;
				i++;
				j++;
			}
			if(i<n1)return 1;
			else if(j<n2)return -1;
			return 0;
		};
		ans.sort(byList);
		return ans;
	}
	
	private void partition(ArrayList<ArrayList<String>> ans, String s, ArrayList<String> l) {
		if(s==null ||s.isEmpty()) {
			ans.add(new ArrayList<>(l));
			return;
		}
		String substring=null;
		for(int i=0;i<s.length();i++) {
			substring = s.substring(0, i+1);
			if(isPallindrome(substring)) {
				l.add(substring);
				partition(ans,s.substring(i+1),l);
				l.remove(l.size()-1);
			}
		}
	}

	private boolean isPallindrome(String s) {
		int i = 0;
		int j = s.length()-1;
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j))return false;
			i++;
			j--;
		}
		return true;
	}
	
	public void printAllConfig(ArrayList<ArrayList<String>> solutions) {
	     for(ArrayList<String> c:solutions) {
	    	 System.out.println(c);
	     }
	}

	public static void main(String[] args) {
		PallindromePartitioning solver = new PallindromePartitioning();
		ArrayList<ArrayList<String>> ans= solver.partition("aab");
		solver.printAllConfig(ans);
	}

}
