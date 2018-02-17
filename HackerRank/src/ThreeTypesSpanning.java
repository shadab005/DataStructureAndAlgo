import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class ThreeTypesSpanning {

	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		InputReader in = new InputReader(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int t = m;
		int node1 = 0, node2 = 0 , type = 0;
		@SuppressWarnings("unchecked")
		ArrayList<Edge> edges[] = (ArrayList<Edge>[]) new ArrayList[4];
		edges[1] = new ArrayList<>();edges[2] = new ArrayList<>();edges[3] = new ArrayList<>();
		while(t-->0) {
			node1 = in.nextInt();
			node2 = in.nextInt();
			type = in.nextInt();
			edges[type].add(new Edge(node1, node2, type));
		}
		
		UnionFind uf = new UnionFind(n+1);
		int edgeCount = 0;
		for(Edge e: edges[3]) {
			if(!uf.isConnected(e.v, e.w)) {
				uf.union(e.v, e.w);
				edgeCount++;
			}
		}
		int menEdgeCount = edgeCount;
		UnionFind menGraph = new UnionFind(uf);
		for(Edge e: edges[1]) {
			if(!menGraph.isConnected(e.v, e.w)) {
				menGraph.union(e.v, e.w);
				menEdgeCount++;
			}
		}
		if(menEdgeCount < n-1) {
			System.out.println(-1);
			return;
		}
		int womenEdgeCount = edgeCount;
		UnionFind womenGraph = new UnionFind(uf);
		for(Edge e: edges[2]) {
			if(!womenGraph.isConnected(e.v, e.w)) {
				womenGraph.union(e.v, e.w);
				womenEdgeCount++;
			}
		}
		if(womenEdgeCount < n-1) {
			System.out.println(-1);
			return;
		}
		System.out.println(m-(menEdgeCount+womenEdgeCount-edgeCount));

	}
	
	static class UnionFind {
		private int[] id; // Stores parent of id
		private int[] numChild;
		public UnionFind(int n) {
			id = new int[n];
			numChild = new int[n];
			for (int i = 0; i < n; i++)	id[i] = i;
		}
		public UnionFind(UnionFind uf) {
		   	id = Arrays.copyOf(uf.id, uf.id.length);
		   	numChild = Arrays.copyOf(uf.numChild, uf.numChild.length);
		}
		public int root(int i) {
			while (i != id[i])i = id[i];
			return i;
		}
		public int rootInPathCompression(int i) {
			while (i != id[i]) {
				id[i] = id[id[i]];
				i = id[i];
			}
			return i;
		}
		public boolean isConnected(int p, int q) {
			return rootInPathCompression(p) == rootInPathCompression(q);
		}
		public void union(int p, int q) {
			int i = rootInPathCompression(p);
			int j = rootInPathCompression(q);
			if (i == j)	return;
			if (numChild[i] < numChild[j]) {
				id[i] = j;
				numChild[j] = numChild[j] + numChild[i] + 1;
			} else {
				id[j] = i;
				numChild[i] = numChild[i] + numChild[j] + 1;
			}
		}
	}
	
	static class Edge {
		public int type;
		private final int v;
		private final int w;
		public Edge(int v, int w, int type) {
			this.type = type;
			this.v = v;
			this.w = w;
		}
		public int either() {return v;}
		public int other(int vertex) {
			if (vertex == v)
				return w;
			else if (vertex == w)
				return v;
			else
				throw new IllegalArgumentException("Illegal endpoint");
		}
		public String toString() {return v + "--" + w + " => " + type;}
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
