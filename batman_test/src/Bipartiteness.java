import java.util.HashSet;
import java.util.Scanner;

public class Bipartiteness {

	static class Node {
		int id;
		int color; //0 red 1 black
		int degree;
		HashSet<Integer> neighbours;
		Node(int i){
			neighbours = new HashSet<>();
			id=i;
		}
	}
	static Node[] node;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		node = new Node[n + 1];
		for (int i = 1; i <= n; i++) 
		{
			node[i] = new Node(i);
		}

		int x,y=0;
		x = in.nextInt();
		y = in.nextInt();
		node[x].degree++;
		node[y].degree++;
		node[x].neighbours.add(y);
		node[y].neighbours.add(x);
		
		Node startNode = node[x];
		
		for(int i = 2;i<n;i++) {
			x = in.nextInt();
			y = in.nextInt();
			node[x].degree++;
			node[y].degree++;
			node[x].neighbours.add(y);
			node[y].neighbours.add(x);
		}
		
		color = new int[2];
		visited = new boolean[n+1];
		visited[startNode.id]=true;
		colorAllNodes(startNode,0);
		
		visited = new boolean[n+1];
		visited[startNode.id]=true;
		countMaxEdge(startNode);
		System.out.println(total);
		in.close();
	}
	
	private static void countMaxEdge(Node n) {
		if(n.color==0)
		total+=color[1]-n.degree;
		for(Integer neigbour:n.neighbours) {
			if(!visited[neigbour]) {
				visited[neigbour]=true;
				countMaxEdge(node[neigbour]);
			}
		}
	}

	static int color[];
	static boolean visited[];
	static long total=0;

	private static void colorAllNodes(Node n, int c) {
		n.color=c;
		color[c]++;
		for(Integer neigbour:n.neighbours) {
			if(!visited[neigbour]) {
				visited[neigbour]=true;
				colorAllNodes(node[neigbour], c^1);
			}
		}
	}
	
}
