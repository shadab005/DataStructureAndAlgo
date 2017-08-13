import java.util.Scanner;

class TotalDecodingMessages {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		boolean isValid=true;
		while(t-->0){
			int n = in.nextInt();
			String s = in.next();
			isValid=true;
			int count[] = new int[n];
			int i = 1;
			if(s.charAt(0)=='0')i=n;
			else count[0] = 1;
			for(; i< n ;i++){
				if(s.charAt(i)-48!=0)
		    	count[i] = count[i-1];
		    	int x = Integer.parseInt(s.charAt(i-1)+""+s.charAt(i));
		    	if(s.charAt(i)-48==0 && !(x > 9 && x <=26)){
		    		isValid=false;
		    	}
		    	if(x >9 && x<=26){
		    		if(i>1)
		    		count[i]+=count[i-2];
		    		else count[i]++;
		    	}
		    }
			if(isValid)
			System.out.println(count[n-1]);
			else System.out.println(0);
			
		}
		in.close();
	    //Util.printArray(count);

	}

}
