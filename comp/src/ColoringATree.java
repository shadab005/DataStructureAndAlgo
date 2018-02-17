import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class ColoringATree {

	private int n = 0;
	public ArrayList<Integer>[] vertex;
	public int finalColor[];
	public int currentColor[];
	
	public boolean visited[];
	
	@SuppressWarnings("unchecked")
	ColoringATree(int n){
		this.n = n;
		vertex = (ArrayList<Integer>[])new ArrayList[n+1];
		for(int i=0;i<=n;i++)vertex[i]=new ArrayList<>();
		
		finalColor = new int[n+1];
		currentColor = new int[n+1];
	}
	
	private void solve() {
		int ans = 0;
		
		//Do bfs
		visited = new boolean[n+1];
		Queue<Integer> queue = new ArrayDeque<>(n);
		queue.add(1);
		visited[1]=true;
		int node = 0;
		while(!queue.isEmpty()) {
			node = queue.remove();
			if(currentColor[node] != finalColor[node]) {
				currentColor[node] = finalColor[node];
				ans++;
			}
			colorChildren(node, finalColor[node]);
			
		    for(int u : vertex[node]) {
		    	if(!visited[u]) {
		    		visited[u]=true;
		    		queue.add(u);
		    	}
		    }
		}
		System.out.println(ans);
		
	}
	
	private void colorChildren(int v, int color) {
		for(int x:vertex[v]) {
			if(!visited[x])currentColor[x]=color;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ColoringATree g = new ColoringATree(n);
		for(int i=2;i<=n;i++) {
			g.connect(i,in.nextInt());
		}
		
		for(int i = 1 ; i<=n ;i++) {
			g.finalColor[i]=in.nextInt();
		}
		g.solve();
		in.close();
	}


	public void connect(int i, int j) {
		vertex[i].add(j);
		vertex[j].add(i);
	}

}
