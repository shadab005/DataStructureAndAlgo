import java.io.DataInputStream;
import java.io.IOException;

class GSS3 {
	
	static class DataNode{
		int max;
		int leftMax;
		int rightMax;
		int totalSum;
		public DataNode(){}
		public DataNode(int data) {
			max = data;
			leftMax=data;
			rightMax =data;
			totalSum=data;
		}
		
		public DataNode(int max, int leftMax, int rightMax, int totalSum){
			this.max = max;
			this.leftMax=leftMax;
			this.rightMax=rightMax;
			this.totalSum=totalSum;
		}
	}
	DataNode st[];
	int input[];
	public GSS3(int a[]) {
		input=a;
		int n = a.length;
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int max_size = 2 * (int) Math.pow(2, x) - 1;
		st=new DataNode[max_size];
		buildSegmentTree(0,n-1,0);
	}
	public void buildSegmentTree(int low, int high, int pos){
		if(low==high){
			st[pos]=new DataNode(input[low]);
			return;
		}
		int mid=low+(high-low)/2;
		buildSegmentTree(low, mid, 2*pos+1);
		buildSegmentTree(mid+1, high, 2*pos+2);
		DataNode left = st[2*pos+1];
		DataNode right = st[2*pos+2];
		int totalSum = left.totalSum+right.totalSum;
		int leftMax = Math.max(left.leftMax, left.totalSum+right.leftMax);
		int rightMax = Math.max(right.rightMax, right.totalSum+left.rightMax);
		int max = Math.max(left.max, 
				Math.max(right.max, left.rightMax+right.leftMax));
		st[pos]=new DataNode(max,leftMax,rightMax,totalSum);
	}
	
	public int query(int qlow, int qhigh){
		return query(0,input.length-1,qlow,qhigh,0).max;
	}
	private DataNode query(int low, int high, int qlow, int qhigh, int pos) {
		if(qlow<=low && qhigh>=high){
			return st[pos];
			//new DataNode(st[pos].max,st[pos].leftMax,
			//		st[pos].rightMax,st[pos].totalSum);
		}
		if(qhigh<low||qlow>high)return null;
		int mid=low+(high-low)/2;
		DataNode left = query(low, mid, qlow, qhigh, 2*pos+1);
		DataNode right = query(mid+1, high, qlow, qhigh, 2*pos+2);
		
		if(left!=null && right!=null){
		return merge(left,right);
		}else{
			if(left!=null)return left;
			else return right;
		}
	}
	
	public void updateSegmentTree(int[] a, int index, int val) {
		a[index]=val;
		updateSegmentTree(index, val,0,input.length-1,0);
	}
    
	private void updateSegmentTree(int index, int val, int low, int high, int pos) {
		if(index<low || index > high) return;
		if(low==high){
			st[pos]=new DataNode(val);
			return;
		}
		int mid=(low+high)/2;
		updateSegmentTree(index,val,low,mid,2*pos+1);
		updateSegmentTree(index,val,mid+1,high,2*pos+2);
		DataNode left = st[2*pos+1];
		DataNode right = st[2*pos+2];
		st[pos].totalSum = left.totalSum+right.totalSum;
		st[pos].leftMax = Math.max(left.leftMax, left.totalSum+right.leftMax);
		st[pos].rightMax = Math.max(right.rightMax, right.totalSum+left.rightMax);
		st[pos].max = Math.max(left.max, 
				Math.max(right.max, left.rightMax+right.leftMax));
	}
	
	DataNode merge(DataNode left, DataNode right){
		DataNode node = new DataNode();
		node.totalSum=left.totalSum;
		node.leftMax=Math.max(left.leftMax, left.totalSum+right.leftMax);
		node.rightMax=Math.max(right.rightMax, left.rightMax+right.totalSum);
		node.max=Math.max(left.max, Math.max(right.max, left.rightMax+right.leftMax));
		return node;
	}
	
	private static Reader in;
	public static void main(String[] args) throws IOException {
	  in = new Reader();
	  int n=in.nextInt();
	  int a[]=new int[n];
      for(int i=0;i<n;i++)a[i]=in.nextInt();
      GSS3 segmentTree = new GSS3(a);
      StringBuilder sb = new StringBuilder("");
      int m=in.nextInt();
      for(int j=1;j<=m;j++){
    	  int op = in.nextInt();
    	  int qlow= in.nextInt();
    	  int qhigh= in.nextInt();
    	  if(op==0){
    		  segmentTree.updateSegmentTree(a, qlow-1, qhigh);
    	  }else{
    		  sb.append(segmentTree.query(qlow-1, qhigh-1));
    		  sb.append(System.getProperty("line.separator"));
    	  }
      }
      System.out.print(sb);
	}
	
	static class Reader {
	    final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
	    public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
	    }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
	    }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];}
	    private void fillBuffer() throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;}
	    
	}
	
}
