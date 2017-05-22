import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SnakeProcession {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new java.io.BufferedReader(new InputStreamReader (System.in));
		char[] ch = {'H','T'};
		int expected = 0;
		int R = Integer.parseInt(r.readLine());
		//int n = 0;
		boolean valid = true;
		for(int i = 0; i<R ;i++){
			valid=true;
			expected=0;
			r.readLine();
			String s = r.readLine();
			char last='T';
			char snake[]=s.toCharArray();
			for(char c:snake){
				if(c!='.'){
					if(c==ch[expected]){
						expected=(expected+1)%2;
						last=c;
					}else{
					//	System.out.println("###c="+c);
						valid=false;
						break;
					}
				}
			}
			//System.out.println("Lat = " + last + " Valid = " + valid);
			if(!valid || last!='T'){
				System.out.println("Invalid");
			}else{
				System.out.println("Valid");
			}
		}

	}

}
