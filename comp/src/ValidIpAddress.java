import java.util.ArrayList;

public class ValidIpAddress {

	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> ans = new ArrayList<>();
		if(s.length()<4)return ans;
		getIpAddresses(s, 0, 4, ans, "");
		//System.out.println(ans);
		for(int i = 0 ; i< ans.size() ;i++) {
			String ss = ans.remove(i);
			ans.add(i,ss.substring(1));
		}
		ans.sort(null);
		//System.out.println(ans);
		return ans;
	}
	
	private void getIpAddresses(String s, int k ,int dotsRemaining, ArrayList<String> ans, String current) {
		if(k>=s.length())return;
		if(dotsRemaining==0) {
			
		}else if(dotsRemaining==1) {
			if(s.charAt(k)=='0' && k<s.length()-1) {
				return;
			}
			if(Integer.parseInt(s.substring(k))>255)return ;
			ans.add(current+="."+s.substring(k));
		}else {
			if(s.charAt(k)=='0') {
				getIpAddresses(s, k+1, dotsRemaining-1, ans, current+".0");
			}
			else if(k < s.length()-2) {
				for(int i=0;i<3;i++) {
					String next = s.substring(k, k+i+1);
					//System.out.println("next="+next+ " char At k = " + s.charAt(k) +" dots = " + dotsRemaining);
					if(Integer.parseInt(next)<=255)
					getIpAddresses(s, k+i+1, dotsRemaining-1, ans, current+"."+next);
				}
			}else if(k < s.length()-1) {
				for(int i=0;i<2;i++) {
					getIpAddresses(s, k+i+1, dotsRemaining-1, ans, current+"."+s.substring(k, k+i+1));
				}
			}else if(k<s.length()){
				for(int i=0;i<1;i++) {
					getIpAddresses(s, k+i+1, dotsRemaining-1, ans, current+"."+s.substring(k, k+i+1));
				}
			}
		}
	}

	public static void main(String[] args) {
		//0.10.0.100 0.100.10.0
		System.out.println(
				new ValidIpAddress().restoreIpAddresses("0100100"));

	}

}
