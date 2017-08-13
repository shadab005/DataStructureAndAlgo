import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class SGFlip {

	int st[];
	int lazy[];
	int n ;
	
	public SGFlip(int n) {
		this.n = n;
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int max_size = 2 * (int) Math.pow(2, x) - 1;
		st = new int[max_size];
		lazy = new int[max_size];
	}
	
	public long countOne(int qlow, int qhigh){
		return query(0,n-1,qlow,qhigh,0);
	}

	private int query(int low, int high, int qlow, int qhigh, int pos) {
		if(low>high)return 0;
		if(lazy[pos]!=0){
			st[pos]=(high-low+1)-st[pos];
			if(low!=high){
				lazy[2*pos+1]=(lazy[2*pos+1]+1)%2;
				lazy[2*pos+2]=(lazy[2*pos+2]+1)%2;
			}
			lazy[pos]=0;
		}
		if(qlow>high || qhigh < low)return 0;
		if(qlow<=low && qhigh>=high)return st[pos];
		int mid = (low+high)/2;
		return query(low, mid, qlow, qhigh, 2*pos+1)+
				query(mid+1, high, qlow, qhigh, 2*pos+2);
	}
	
	public void flip(int qlow, int qhigh){
		updateSegmentTree(0, n-1, qlow, qhigh , 0);
	}
	
	private void updateSegmentTree(int low, int high, int qlow, int qhigh, int pos) {
		if(low>high)return;
		if(lazy[pos]!=0){
			st[pos]=(high-low+1)-st[pos];
			if(low!=high){
				lazy[2*pos+1]=(lazy[2*pos+1]+1)%2;
				lazy[2*pos+2]=(lazy[2*pos+2]+1)%2;
			}
			lazy[pos]=0;
		}
		//No overlap
		if(qlow>high || qhigh<low)return;
		//Complete overlap
		if(qlow<=low && qhigh>=high){
			st[pos]=(high-low+1)-st[pos];
			if(low!=high){
				lazy[2*pos+1]=(lazy[2*pos+1]+1)%2;
				lazy[2*pos+2]=(lazy[2*pos+2]+1)%2;
			}
			return;
		}
		//Partial overlap
		int mid = (low+high)/2;
		updateSegmentTree(low, mid, qlow, qhigh, 2*pos+1);
		updateSegmentTree(mid+1, high, qlow, qhigh, 2*pos+2);
		st[pos]=st[2*pos+1] + st[2*pos+2];
	}

	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();
		int q = in.nextInt();
		SGFlip sg = new SGFlip(n);
		while(q-->0){
			int op  = in.nextInt();
			if(op==0){
			    sg.flip(in.nextInt(), in.nextInt());
			}else{
				System.out.println(sg.countOne(in.nextInt(), in.nextInt()));
			}
		}
		in.close();

	}

}
