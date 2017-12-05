import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
 
public class MonkeyKingdom {
 
	static ArrayList<ArrayList<Integer>> vertex;
	static long a[];
	public static void main(String[] args) {
		 new Thread(null,null,"1",0x999999)
	        {
	           public void run() 
	           {
	               try
	               {
	                   solve();
	               }
	               catch(Exception e)
	               {   
	                   e.printStackTrace();
	                   System.exit(1);
	               }
	           }
	        }.start();
	}
	
	static void solve() {
		InputReader in = new InputReader(System.in);
		int t = in.nextInt();
		int n,m=0;
		while(t-->0) {
			n = in.nextInt();
			m = in.nextInt();
			vertex = new ArrayList<>(n+1);
			vertex.add(new ArrayList<>());
			for(int i = 1;i<=n;i++) {
				vertex.add(new ArrayList<>());
			}
			a = new long[n+1];
			for(int i = 0;i<m;i++) {
				connect(in.nextInt(), in.nextInt());
			}
			for(int i = 1;i<=n;i++) {
				a[i] = in.nextLong();
			}
			findNumberOfGoldCoins(n);
			
		}
	}
	
	static boolean marked[];
	static long total = 0; 
	private static void findNumberOfGoldCoins(int n) {
		marked = new boolean[n+1];
		long ans = 0;
		
		for(int i=1;i<=n;i++) {
			if(!marked[i]) {
				total =0;
				dfs(i);
				ans = Math.max(total, ans);
			}
		}
		System.out.println(ans);
	}
	static void dfs(int v) {
		marked[v] = true;
		total+=a[v];
		for(int e : vertex.get(v)) {
			if(!marked[e]) {
				dfs(e);
			}
		}
		
	}
	
	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		marked[v] = true;
		int z = 0;
		while(!q.isEmpty()) {
			z = q.remove();
			total+=a[z];
			for(int e : vertex.get(z)) {
				if(!marked[e]) {
					q.add(e);
					marked[e]=true;
				}
			}
		}
	}
 
	static public void connect(int first,int second){
		vertex.get(first).add(second);
		vertex.get(second).add(first);
	}
	
	static class InputReader {
		 
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
 
        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
 
}