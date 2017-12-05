import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;

/*
 * https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/benny-and-the-universe/
 * 
 */
public class LinearDiophantineEqnNonNegativeSolnExistence {

	static final double LIMIT = 1e9;

	public static void main(String[] args) {

		//Scanner in = new Scanner(System.in);
		InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int q = in.nextInt();
		int d[] = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = in.nextInt();
		}
		Arrays.sort(d);

		int cost[] = new int[d[0]]; // This will contain minimum cost to reach ith node
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[0] = 0;

		LinkedList<Integer> queue = new LinkedList<>();
	//	queue.add(0);// Adding vertex 0 in the begining
		/*for(int i=0;i<d[0];i++){
			queue.add(i);
		}*/
		queue.add(0);
		int x = 0;
		int r = 0;
		while (!queue.isEmpty()) {
			x = queue.remove(0);
			if (cost[x] == Integer.MAX_VALUE)
				continue;
			for (int i = 1; i < n; i++) {
				if (cost[x] + d[i] <= LIMIT) {
					r = (d[i] + x) % d[0];
					if (cost[r] > cost[x] + d[i]) {
						cost[r] = cost[x] + d[i];
						queue.add(r);
					}
				}
			}
		}

		while (q-- > 0) {
			x = in.nextInt();
			if (cost[x % d[0]] <= x)
				out.println("YES");
			else
				out.println("NO");
		}

		out.close();

	}

	public static void swap(int[] d, int i, int j) {
		int temp = d[i];
		d[i] = d[j];
		d[j] = temp;
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
