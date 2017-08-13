package datastructure.segmenttree;

import java.io.IOException;

public class SegmentTree {
	
	int segmentTree[];
	int input[];

	public SegmentTree(int[] a) {
		int n = a.length;
		input = a;
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int max_size = 2 * (int) Math.pow(2, x) - 1;
		segmentTree = new int[max_size];//not 2n-1. see below for an example
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
		if(qlow<=low && high<=qhigh)return segmentTree[pos];
		if(qlow>high || qhigh < low)return Integer.MAX_VALUE;
		int mid = (low+high)/2;
		return Math.min(rangeMinimumQuery(low, mid, qlow, qhigh, 2*pos+1),
				        rangeMinimumQuery(mid+1, high, qlow, qhigh, 2*pos+2)
				       );
	}
    
    public void updateSegmentTree(int[] a, int index, int val) {
		a[index]=val;
		updateSegmentTree(index, val,0,input.length-1,0);
	}
    
	private void updateSegmentTree(int index, int val, int low, int high, int pos) {
		if(index<low || index > high) return;
		if(low==high){
			segmentTree[pos]=val;
			return;
		}
		int mid=(low+high)/2;
		updateSegmentTree(index,val,low,mid,2*pos+1);
		updateSegmentTree(index,val,mid+1,high,2*pos+2);
		segmentTree[pos] = Math.min(segmentTree[2*pos+1], segmentTree[2*pos+2]);	
	}
	void printSegmentTree(){
    	for(int i=0;i<segmentTree.length;i++)System.out.print(segmentTree[i]+" ");
    	System.out.println();
    }
	
	public static void main(String[] args) throws IOException {
		int a[]={-200,3,4,-200,6,2,4,-200,5,6 };
		SegmentTree st = new SegmentTree(a);
		st.printSegmentTree();
		System.out.println(st.rangeMinimumQuery(0, 9));
		//st.updateSegmentTree(a, 2, 10);
		//System.out.println(st.rangeMinimumQuery(2, 2));
	}
	/*
	 * -200,3,4,-200,6,2,4,-200,5,6 
	 * This input will prove that space 2*n-1 will give wrong answer
	 */
	
}
