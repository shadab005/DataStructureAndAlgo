
public class DPNumberofWayToDecodeAlphabets {

	public long numDecodings(String s) {
        if(s.charAt(0) == '0')return 0;
        if(s.length()==1)return 1;
        char ch[] = s.toCharArray();
        long n[] = new long[s.length()];
        n[0]=1;
        if(ch[1] == '0') {
        	if(canBeJoined(ch[0],ch[1]))n[1]=1;
        	else return 0;
        }
        else if(canBeJoined(ch[0],ch[1]))n[1]=2;
        else n[1]=1;
        
        for(int i=2; i<ch.length ; i++) {
        	if(ch[i] == '0') {
        		    if(!canBeJoined(ch[i-1], ch[i]))return 0;
        		    else n[i]=n[i-2];
        	}else if(canBeJoined(ch[i-1], ch[i])) {
        		n[i]=n[i-1]+n[i-2];
        	}else {
        		n[i]=n[i-1];
        	}
        }
		return n[ch.length-1];
	}
	
	
	private boolean canBeJoined(char c, char d) {
		int preVal = intVal(c);
        int val = intVal(d);
        if(preVal ==0 || (preVal>2) || (preVal==2 && val > 6 ))return false;
		return true;
	}

	private int intVal(char c) {
		return c-48;
	}

	public static void main(String[] args) {
		DPNumberofWayToDecodeAlphabets d = new DPNumberofWayToDecodeAlphabets();
		System.out.println(d.numDecodings("1214"));

	}

}
