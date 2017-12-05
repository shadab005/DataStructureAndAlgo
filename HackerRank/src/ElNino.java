import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class ElNino {

	static ArrayList<Integer>[] vertex;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out = new PrintStream(new FileOutputStream("out.txt"));
		System.setErr(out);	
		//Scanner in = new Scanner(System.in);
		InputReader in = new InputReader(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		vertex = (ArrayList<Integer>[])new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			vertex[i]=new ArrayList<Integer>();
		}
		
		int a[] = new int[m+1];
		int k[]=new int[n];
		for(int i = 1; i<=m;i++) {
			a[i]=in.nextInt();
			if(a[i]<=n)k[a[i]]=1;
		}
		//Finding cumulative sum
		for(int i = 1; i<n;i++) {
		   	k[i]=k[i]+k[i-1];
		}
		
		for(int i = 1;i<n;i++) {
			vertex[in.nextInt()].add(i+1);
		}
		solve(n,k);
		//in.close();
	}
	static long count = 0;

	private static void solve(int n, int[] k) {
		bfs(1,k,0);
		System.out.println(count);
	}
	public static void dfs(int i, int[] k, int parentCount) {
		 //visited[i]=true;
		 count+=k[parentCount];
		 for(int z:vertex[i]) {
			 dfs(z, k, parentCount+1);
		 }
		
	}
	
	public static void bfs(int i, int[] k, int parentCount) {
		long ans  = 0;
		
		Queue<Pair> q = new LinkedList<>();
		Pair z = new Pair(1,0);
		q.add(z);
		while(!q.isEmpty()) {
			z = q.remove();
			ans+=k[z.parentCount];
			for(int child:vertex[z.id]) {
				q.add(new Pair(child,z.parentCount+1));
			}
		}
		count = ans;
	}
	
	static class Pair{
		int id, parentCount;
		Pair(int a,int b){id=a;parentCount=b;}
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
