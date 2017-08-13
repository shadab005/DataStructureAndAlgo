package datastructure.segmenttree;


/*
 * Minimum Range Query with frequent updates
 * For frequent update criteria we follow lazy propagation
 */
public class LazySegmentTree {
	
	int segmentTree[];
	int lazy[];
	int input[];

	public LazySegmentTree(int[] a) {
		int n = a.length;
		input = a;
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int max_size = 2 * (int) Math.pow(2, x) - 1;
		segmentTree = new int[max_size];//not 2n-1. see below for an example
		lazy = new int[max_size];
		for(int i=0;i<segmentTree.length;i++)segmentTree[i]=Integer.MAX_VALUE;
		buildMinSegmentTree(0, n-1, 0);
	}
	public void buildMinSegmentTree(int low, int high, int pos){
		if(low==high){
			segmentTree[pos]=input[low];
			return;
		}
		int mid = (low+high)/2;
		buildMinSegmentTree(low, mid, 2*pos+1);
		buildMinSegmentTree(mid+1, high, 2*pos+2);
		segmentTree[pos]=Math.min(segmentTree[2*pos+1], segmentTree[2*pos+2]);
	}
	
	public int rangeMinimumQuery(int qlow, int qhigh) {
		return rangeMinimumQuery(0,input.length-1,qlow,qhigh,0);
	}
	
    private int rangeMinimumQuery(int low, int high, int qlow, int qhigh, int pos) {
    	
    	if(low>high)return Integer.MAX_VALUE;
    	if(lazy[pos]!=0){
			segmentTree[pos]+=lazy[pos];
			if(low!=high){
				lazy[2*pos+1]+=lazy[pos];
				lazy[2*pos+2]+=lazy[pos];
			}
			lazy[pos]=0;
		}
    	//No overlap
		if(qlow>high || qhigh < low)return Integer.MAX_VALUE;
		//Total overlap
		if(qlow<=low && high<=qhigh)return segmentTree[pos];
		//Partial overlap
		int mid = (low+high)/2;
		return Math.min(rangeMinimumQuery(low, mid, qlow, qhigh, 2*pos+1),
				        rangeMinimumQuery(mid+1, high, qlow, qhigh, 2*pos+2)
				       );
	}
    
    public void updateSegmentTree(int[] a, int qlow, int qhigh, int delta) {
		for(int i=qlow;i<=qhigh;i++)a[i]+=delta;
		updateSegmentTree(0, a.length-1, qlow, qhigh , 0, delta);
	}
    
	private void updateSegmentTree(int low, int high, int qlow, int qhigh , int pos, int delta) {
		if(low>high)return;
		
		if(lazy[pos]!=0){
			segmentTree[pos]+=lazy[pos];
			if(low!=high){
				lazy[2*pos+1]+=lazy[pos];
				lazy[2*pos+2]+=lazy[pos];
			}
			lazy[pos]=0;
		}
		
		//No overlap
		if(qlow > high || qhigh < low) return;
		
		//Total overlap
		if(qlow<=low && qhigh>=high){
			segmentTree[pos]+=delta;
			if(low!=high){
				lazy[2*pos+1]+=delta;
				lazy[2*pos+2]+=delta;
			}
			return;
		}
		
		//Otherwise partial overlap so look at both side of tree, so look both and left
		int mid=(low+high)/2;
		updateSegmentTree(low, mid, qlow, qhigh, 2*pos+1, delta);
		updateSegmentTree(mid+1, high, qlow, qhigh, 2*pos+2, delta);
		segmentTree[pos]=Math.min(segmentTree[2*pos+1], segmentTree[2*pos+2]);
	}
	void printSegmentTree(){
    	for(int i=0;i<segmentTree.length;i++)System.out.print(segmentTree[i]+" ");
    	System.out.println();
    }
	
	void printLazyTree(){
    	for(int i=0;i<lazy.length;i++)System.out.print(lazy[i]+" ");
    	System.out.println();
    }
	
	public static void main(String[] args){
		int a[]={2,3,-1,4};
		LazySegmentTree st = new LazySegmentTree(a);
		st.printSegmentTree();
		//System.out.println(st.rangeMinimumQuery(0, 3));
		st.updateSegmentTree(a, 0, 3, 2);
		st.printLazyTree();
		//st.printSegmentTree();
		//System.out.println(st.rangeMinimumQuery(0, 3));
		st.updateSegmentTree(a, 2, 2, 5);
		st.printLazyTree();
		System.out.println(st.rangeMinimumQuery(1, 2));
		//st.printSegmentTree();
		//System.out.println(st.rangeMinimumQuery(0, 3));

	}
}
