import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

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

public class Solution {

	static HashMap<Integer, EdgeNode> g;
	static int count = 0;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();
		g = new HashMap<>();
		visited=new boolean[n];
	    for(int  i = 1; i<= n; i++){
	    	int e = in.nextInt();
	    	if(e==0){
	    		System.out.println(1);
	    		System.exit(0);
	    	}
	    	EdgeNode edge = getEdge(in.nextInt());
	    	g.put(i, edge);
	    	for(int j = 2; j<=e; j++){
	    		edge.next=getEdge(in.nextInt());
	    		edge=edge.next;
	    	}
	    }
	    //System.out.println("end");
	   // printGraph(n);
	    getCount(n);
	    in.close();

	}
	static int last=-1;
	static int sol=0;
	static void getCount(int n){
		//for(int i = 1;i<=n;i++)visited[i]=false;
		for(int i = 1; i <= n;i++){
			visited=new boolean[n];
		  count=0;
		  dfs(i);
		  if(count==n){
			  sol++;
		  }
		}
		System.out.println(sol);
	}
	
	static void dfs(int j){
		EdgeNode e=g.get(j);
		count++;
		while(e!=null){
			if(!visited[e.id]){
				visited[e.id]=true;
				dfs(e.id);
				e=e.next;////////
			}
		}
	}
	
	
	static EdgeNode getEdge(int x){
		return new EdgeNode(x);
	}
	
	static void printGraph(int n){
		//System.out.println("Here");
		for(int i = 1 ; i<= n ;i++){
			EdgeNode e = g.get(i);
			while(e!=null){
				System.out.print(e.id + " ");
				e=e.next;
			}
			System.out.println();
		}
	}
}

class EdgeNode{
	int id;
	EdgeNode next;
	EdgeNode(int x){
		id=x;
	}
}


