import java.util.ArrayList;

public class DPEqualAveragePartition {

	private ArrayList<Integer> a = null;
	ArrayList<Integer> ans = null;
	int total=0;
	ArrayList<ArrayList<Integer>> finalAns;
	public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> a) {
		a.sort(null);
		for(int z:a)total+=z;
		this.a = a;
		ans = new ArrayList<>();
		finalAns = new ArrayList<>();
		return null;
    }
	
	public boolean isAvgSet(int n, int k) {
		if(n<0)return false;
		if(k*1.0/ans.size()==(total-k)*1.0/(a.size()-ans.size())) {
			if(finalAns.isEmpty()) {
				finalAns.add(new ArrayList<>(ans));
			}else {
				if(finalAns.get(0).size()>ans.size()) {
					finalAns= new ArrayList<>();
					finalAns.add(new ArrayList<>(ans));
				}else if(finalAns.get(0).size()==ans.size()) {
					finalAns.add(new ArrayList<>(ans));
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
