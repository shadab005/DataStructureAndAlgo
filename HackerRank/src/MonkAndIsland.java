import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MonkAndIsland {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			ArrayList<Integer>[] vertex = (ArrayList<Integer>[]) new ArrayList[n + 1];
			for (int i = 0; i < n + 1; i++) {
				vertex[i] = new ArrayList<>();
			}
			// Creating edges
			for (int i = 0; i < m; i++) {
				int p = in.nextInt();
				int q = in.nextInt();
				vertex[p].add(q);
				vertex[q].add(p);
			}
			boolean visited[] = new boolean[n + 1];
			int level[] = new int[n + 1];
			Queue<Integer> q = new LinkedList<>();
			level[1] = 0;

			q.add(1);
			visited[1] = true;
			boolean found = false;
			while (!q.isEmpty() && !found) {
				int x = q.remove();
				for (int z : vertex[x]) {
					if (z == n) {
						System.out.println(level[x] + 1);
						found = true;
						break;
					}
					if (!visited[z]) {
						level[z] = level[x] + 1;
						visited[z] = true;
						q.add(z);
					}
				}
			}
		}

		in.close();

	}

}
