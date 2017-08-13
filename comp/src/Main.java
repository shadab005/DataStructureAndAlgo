import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int par[], comp;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = in.nextInt();

		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			int degree[] = new int[n];
			ArrayList<Integer> adj[] = new ArrayList[n];
			ArrayList<Integer> deg[] = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				deg[i] = new ArrayList<Integer>();
				adj[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < m; i++) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				adj[u].add(v);
				adj[v].add(u);
				degree[u]++;
				degree[v]++;
			}

			for (int i = 0; i < n; i++)
				deg[degree[i]].add(i);

			int ans[] = new int[n];

			par = new int[n];
			Arrays.fill(par, -1);
			comp = n;
			StringBuilder sb = new StringBuilder("");
			ans[n - 1] = n - 1;

			for (int i = n - 1; i >= 1; i--) {
				for (int u : deg[i]) {
					for (int v : adj[u]) {
						if (degree[v] >= i)
							merge(u, v);
					}
				}
				ans[i - 1] = comp - 1;
			}

			for (int i = 0; i < n; i++)
				sb.append(ans[i] + " ");

			System.out.println(sb.toString().substring(0, sb.length() - 1));
		}
		in.close();
	}

	static int root(int x) {
		return (par[x] < 0) ? x : (par[x] = root(par[x]));
	}

	static void merge(int x, int y) {
		x = root(x);
		y = root(y);

		if (x == y)
			return;

		comp--;

		if (par[x] < par[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}

		par[y] += par[x];
		par[x] = y;
	}

}