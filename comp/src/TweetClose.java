import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TweetClose {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new java.io.BufferedReader(new InputStreamReader (System.in));
		String s = r.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int n_open = 0;
		int swtch[] = new int[n];
		int base = 0;
		for(int i = 0 ; i < k ;i++){
			s = r.readLine();
			st = new StringTokenizer(s);
			String first = st.nextToken();
			if(first.equals("CLOSEALL")){
				n_open = 0;
				base=base+1000;
			}else{
				int click  = Integer.parseInt(st.nextToken())-1;
				if(swtch[click]>=base){
				if((swtch[click]&1)==0){ //Even means already closed
					swtch[click]++;
					n_open++;
				}else{ //Odd means already open.Therefore we have to close
					swtch[click]++;
					n_open--;
				}
				}else{
					swtch[click]=base+1;
					n_open++;
				}
			}
			System.out.println(n_open);
		}

	}

}
