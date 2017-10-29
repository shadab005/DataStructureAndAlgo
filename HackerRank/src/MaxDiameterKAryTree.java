import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

public class MaxDiameterKAryTree {
	
	ArrayList<Edge>[] g;
	int n;
	
	@SuppressWarnings("unchecked")
	public MaxDiameterKAryTree(int n) {
	  g = (ArrayList<Edge>[])new ArrayList[n+1];
	  for(int i=0;i<=n;i++)g[i]=new ArrayList<>();
	  this.n=n;
	}
	
	void addEdge(int first, int second, int cost) {
		g[first].add(new Edge(second, cost));
		g[second].add(new Edge(first, cost));
	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
       // PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while(t-->0) {
        	int n = in.nextInt();
        	MaxDiameterKAryTree m = new MaxDiameterKAryTree(n);
        	for(int i=1;i<n;i++) {
        		m.addEdge(in.nextInt(), in.nextInt(), in.nextInt());
        	}
        	int diameter = m.getDiameter(1);
        	int cost=0;
        	if(diameter>10000)cost=10000;
        	else if(diameter>1000)cost=1000;
        	else if(diameter>100)cost=100;
        	System.out.println(cost +" " + diameter);
        }

	}
	
	private int max=0;
	public int getDiameter(int source) {
		max = 0;
		boolean visited[] = new boolean[n+1];
		int ans = dfs(source, visited);
		return Math.max(ans, max);
	}

	private int dfs(int source, boolean visited[]) {
		int fMax=0;
		int sMax=0;
		visited[source]=true;
		Stack<Integer> s = new Stack<>();
		s.push(source);
		while(!s.isEmpty()) {
			int x = s.pop();
			for(Edge e: g[x]) {
				
			}
		}
		/*for(Edge e: g[source]) {
			if(!visited[e.id]) {
				int cost = dfs(e.id, visited)+e.cost;
				if(cost>=fMax) {
					sMax=fMax;
					fMax=cost;
				}else if(cost>sMax) {
					sMax=cost;
				}
			}
		}
		max=Math.max(max, fMax+sMax);*/
		return fMax;
	}

	class Edge{
		int id;
		int cost;
		Edge(int id, int cost){
			this.id=id;
			this.cost=cost;
		}
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
