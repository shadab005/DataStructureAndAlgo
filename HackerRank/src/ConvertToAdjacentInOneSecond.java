import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConvertToAdjacentInOneSecond {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		queue = new LinkedList<>();
		int a[][] = new int[N][M];
		d = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[i][j] = in.nextInt();
				d[i][j]=Integer.MAX_VALUE-1;
				if(a[i][j]==2) {
					queue.add(i * PRIME + j);
					d[i][j]=0;
				}
			}
		}
		int ans = calculateMaxStep(a, N, M);
		System.out.println(ans);
		in.close();

	}

	static int d[][];
	static boolean visited[];
	static Queue<Integer> queue;
	private static final int PRIME = 1009;

	static int calculateMaxStep(int[][] a, int n, int m) {

		visited = new boolean[n * PRIME + m];
		/*for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i * PRIME + j] && a[i][j] == 2) {
					bfs(a, i, j, n, m);
				}
			}
		}*/

		bfs(a,n,m);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 1) {
					if (d[i][j] == Integer.MAX_VALUE-1) {
						return -1;
					} else {
						ans = Math.max(ans, d[i][j]);
					}
				}
			}
		}
		//Util.printArray(d);
		return ans;
	}

	public static void bfs(int[][] a, int n, int m) {
		int i, j = 0;
		int iNeighbour = 0, jNeigbhour = 0;
		while (!queue.isEmpty()) {
			int z = queue.remove();
			i = z / PRIME;
			j = z % PRIME;
			for (int p = -1; p <= 1; p++) {
				for (int q = -1; q <= 1; q++) {
					iNeighbour = i + p;
					jNeigbhour = j + q;
					if (isValid(p,q) && isValidPosition(iNeighbour, jNeigbhour, n, m) && a[iNeighbour][jNeigbhour] == 1
							&& d[iNeighbour][jNeigbhour] > d[i][j] + 1) {

						d[iNeighbour][jNeigbhour] = d[i][j] + 1;
						visited[(iNeighbour) * PRIME + (jNeigbhour)] = true;
						queue.add((iNeighbour) * PRIME + (jNeigbhour));
					}
				}
			}
		}

	}
	
	private static boolean isValid(int p, int q) {
		if((p==-1 || p==1) && (q==-1 || q==1)) return false;
		return true;
	}


	private static boolean isValidPosition(int i, int j, int N, int M) {
		if (i < 0 || i >= N || j < 0 || j >= M)
			return false;
		return true;
	}

}
