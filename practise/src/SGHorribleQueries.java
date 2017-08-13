import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class SGHorribleQueries {

	long st[];
	long lazy[];
	int n ;
	
	public SGHorribleQueries(int n) {
		this.n = n;
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int max_size = 2 * (int) Math.pow(2, x) - 1;
		st = new long[max_size];
		lazy = new long[max_size];
	}

	public long query(int qlow, int qhigh){
		return query(0,n-1,qlow,qhigh,0);
	}

	private long query(int low, int high, int qlow, int qhigh, int pos) {
		if(low>high)return 0;
		if(lazy[pos]!=0){
			st[pos]+=(long)(1L*(high-low+1)*1L*lazy[pos]);
			if(low!=high){
				lazy[2*pos+1]+=lazy[pos];
				lazy[2*pos+2]+=lazy[pos];
			}
			lazy[pos]=0;
		}
		if(qlow>high || qhigh < low)return 0;
		if(qlow<=low && qhigh>=high)return st[pos];
		int mid = (low+high)/2;
		return query(low, mid, qlow, qhigh, 2*pos+1)+
				query(mid+1, high, qlow, qhigh, 2*pos+2);
	}
	
	
	public void update(int qlow, int qhigh, long delta){
		updateSegmentTree(0, n-1, qlow, qhigh , 0, delta);
	}
	private void updateSegmentTree(int low, int high, int qlow, int qhigh, int pos, long delta) {
		if(low>high)return;
		if(lazy[pos]!=0){
			st[pos]+=(long)(1L*(high-low+1)*1L*lazy[pos]);
			if(low!=high){
				lazy[2*pos+1]+=lazy[pos];
				lazy[2*pos+2]+=lazy[pos];
			}
			lazy[pos]=0;
		}
		//No overlap
		if(qlow>high || qhigh<low)return;
		//Complete overlap
		if(qlow<=low && qhigh>=high){
			st[pos]=st[pos]+(long)(1L*(high-low+1)*1L*delta);
			if(low!=high){
				lazy[2*pos+1]+=delta;
				lazy[2*pos+2]+=delta;
			}
			return;
		}
		//Partial overlap
		int mid = (low+high)/2;
		updateSegmentTree(low, mid, qlow, qhigh, 2*pos+1, delta);
		updateSegmentTree(mid+1, high, qlow, qhigh, 2*pos+2, delta);
		st[pos]=st[2*pos+1] + st[2*pos+2];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		while(t-- > 0){
			SGHorribleQueries sg = new SGHorribleQueries(in.nextInt());
			int queryCount = in.nextInt();
			while(queryCount-- >0){
				int op = in.nextInt();
				if(op==0){
					int qlow = in.nextInt()-1;
					int qhigh = in.nextInt() -1;
					int delta = in.nextInt();
					sg.update(qlow, qhigh, delta);
				}else{
					System.out.println(sg.query(in.nextInt()-1, in.nextInt()-1));
				}
			}
		}
		in.close();
	}

}
