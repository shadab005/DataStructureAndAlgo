import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

class GSS1SegmentTree {

	private static Reader in;
	private static PrintWriter out;
	int st[];
	int input[];
	public GSS1SegmentTree(int a[]) {
		input=a;
		int n = a.length;
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int max_size = 2 * (int) Math.pow(2, x) - 1;
		st=new int[max_size];
		for(int i=0;i<st.length;i++)st[i]=Integer.MIN_VALUE;
		buildSegmentTree(0,n-1,0);
	}
	public void buildSegmentTree(int low, int high, int pos){
		if(low==high){
			st[pos]=input[low];
			return;
		}
		int mid = low+(high-low)/2;
		buildSegmentTree(low, mid, 2*pos+1);
		buildSegmentTree(mid+1, high, 2*pos+2);
		st[pos]=Math.max(st[2*pos+1], st[2*pos+2]);
		st[pos]=Math.max(st[pos], st[2*pos+1]+st[2*pos+2]);
	}
	
	public int query(int qlow, int qhigh){
		return query(0,input.length-1,qlow,qhigh,0);
	}
	private int query(int low, int high, int qlow, int qhigh, int pos) {
		if(qlow<=low && qhigh>=high) return st[pos];
		if(qhigh<low||qlow>high)return Integer.MIN_VALUE;
		int mid=low+(high-low)/2;
		int left = query(low, mid, qlow, qhigh, 2*pos+1);
		int right = query(mid+1, high, qlow, qhigh, 2*pos+2);
		return Math.max(left, Math.max(right,left+right));
	}
	public static void main(String[] args) throws IOException {
	  in = new Reader ();
	  out = new PrintWriter (System.out, true);
	  int n=in.nextInt();
      int a[]=new int[n];
      for(int i=0;i<n;i++)a[i]=in.nextInt();
      GSS1SegmentTree segmentTree = new GSS1SegmentTree(a);
      StringBuilder sb = new StringBuilder("");
      int m=in.nextInt();
      for(int i=1;i<=m;i++){
    	  int qlow=in.nextInt();
    	  int qhigh=in.nextInt();
    	  sb.append(segmentTree.query(qlow-1, qhigh-1)+"\n");//-1 because 1 based indexing in question
      }
	  out.println(sb);
      in.close();
	}
}

class Reader {
    final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
    public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
    }public Reader(String file_name) throws IOException{din=new DataInputStream(new FileInputStream(file_name));buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
    }public String readLine() throws IOException{byte[] buf=new byte[64];int cnt=0,c;while((c=read())!=-1){if(c=='\n')break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);
    }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
    }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
    }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;
    }private void fillBuffer() throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
    }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
    }public void close() throws IOException{if(din==null) return;din.close();}
}