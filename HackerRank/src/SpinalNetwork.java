import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

@SuppressWarnings("unchecked")
public class SpinalNetwork {

	static ArrayList<Integer>[] vertex;
	static final String YES = "YES";
	static final String NO = "NO";

	public static void main(String[] args) throws InterruptedException {
		// Scanner in = new Scanner(System.in);
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			vertex = (ArrayList<Integer>[]) new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				vertex[i] = new ArrayList<Integer>();
			}
			int v1 = 0, v2 = 0;
			// Constructing graph
			for (int i = 1; i < n; i++) {
				v1 = in.nextInt();
				v2 = in.nextInt();
				vertex[v1].add(v2);
				vertex[v2].add(v1);
			}
			solve(n, out);

		}
		out.close();

	}

	static boolean answer = true;

	public static void solve(int n, PrintWriter out) {
		answer = true;
		visited = new boolean[n + 1];
		dfs(1);
		if (answer)
			out.println(YES);
		else
			out.println(NO);
	}

	static boolean visited[];

	private static int dfs(int id) {
		if (answer == false)
			return 0;
		visited[id] = true;
		int count = 0;
		int total = 0;
		int c = 0;
		for (int z : vertex[id]) {
			if (!visited[z]) {
				c = dfs(z);
				if (c > 1)
					count++;
				total += c;
			}
		}
		if (count >= 2) {
			if (id == 1 || (vertex[1].size() == 1 && vertex[id].contains(1))) {
				if (count > 2)
					answer = false;
			} else {
                   answer = false;
			}
		}
		return 1 + total;
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
