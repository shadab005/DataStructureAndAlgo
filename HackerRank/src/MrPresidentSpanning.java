import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

//In MST there should not be any self loops
public class MrPresidentSpanning {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long k = in.nextLong();
		
		Comparator<Edge> byEdgeWeight = (Edge o1, Edge o2) -> o1.weight - o2.weight;
		PriorityQueue<Edge> pq = new PriorityQueue<>(byEdgeWeight);
		for (int i = 0; i < m; i++) {
			pq.add(new Edge(in.nextInt() - 1, in.nextInt() - 1, in.nextInt()));
		}
		
		int edgeCount = 0;
		Edge[] mst = new Edge[n - 1];
		UnionFind uf = new UnionFind(n);
		//Kruskal
		long total = 0;
		while (!pq.isEmpty() && edgeCount < n - 1) {
			Edge e = pq.remove();
			int v = e.either();
			int w = e.other(v);
			if (uf.isConnected(v, w))continue;
			uf.union(v, w);
			mst[edgeCount] = e;
			total+=e.weight();
			edgeCount++;
		}
		//System.out.println(edgeCount + "  ### " + (n-1));
		if(edgeCount<n-1) {
			System.out.println(-1);
			return ;
		}
		Arrays.sort(mst, byEdgeWeight);
		if(total<=k) {
			System.out.println(0);
		}else {
			int ans = 0;
			for(int i = mst.length-1;i>=0;i--) {
				if(total > k) {
					total = total - mst[i].weight() + 1;
					ans++;
				}else {
					break;
				}
			}
			if(total>k)System.out.println(-1);
			else System.out.println(ans);
		}
	}

	static class WeightedGraph {

		private int n = 0; // No. of vertices
		private int e = 0; // No. of edges
		private ArrayList<Edge>[] vertex;

		@SuppressWarnings("unchecked")
		public WeightedGraph(int n) {
			if (n < 0)
				throw new IllegalArgumentException("Number of vertices must be nonnegative");
			this.n = n;
			vertex = (ArrayList<Edge>[]) new ArrayList[n];
			for (int v = 0; v < n; v++) {
				vertex[v] = new ArrayList<Edge>();
			}
		}

		public Iterable<Edge> adj(int v) {
			return vertex[v];
		}

		public int edgeCount() {
			return e;
		}

		public int n() {
			return n;
		}

		public int degree(int v) {
			return vertex[v].size();
		}

		public void addEdge(Edge edge) {
			int v = edge.either();
			int w = edge.other(v);
			vertex[v].add(edge);
			vertex[w].add(edge);
			e++;
		}

		public Iterable<Edge> edges() {
			ArrayList<Edge> list = new ArrayList<Edge>();
			for (int v = 0; v < n; v++) {
				for (Edge e : vertex[v]) {
					if (e.other(v) > v) {
						list.add(e);
					}
				}
			}
			return list;
		}

	}

	static class Edge implements Comparable<Edge> {

		public int weight;
		private final int v;
		private final int w;

		public Edge(int v, int w, int weight) {
			this.weight = weight;
			this.v = v;
			this.w = w;
		}

		// Weight of the edge
		public int weight() {
			return weight;
		}

		public int either() {
			return v;
		}

		public int other(int vertex) {
			if (vertex == v)
				return w;
			else if (vertex == w)
				return v;
			else
				throw new IllegalArgumentException("Illegal endpoint");
		}

		@Override
		public String toString() {
			return v + "--" + w + " => " + weight;
		}

		@Override
		public int compareTo(Edge that) {
			return this.w - that.w;
		}
	}

	static class UnionFind {

		private int[] id; // Stores parent of id
		private int[] numChild;

		public UnionFind(int n) {
			id = new int[n];
			numChild = new int[n];
			for (int i = 0; i < n; i++)
				id[i] = i;
		}

		public int root(int i) {
			while (i != id[i])
				i = id[i];
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
			if (i == j)
				return;
			if (numChild[i] < numChild[j]) {
				id[i] = j;
				numChild[j] = numChild[j] + numChild[i] + 1;
			} else {
				id[j] = i;
				numChild[i] = numChild[i] + numChild[j] + 1;
			}
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
