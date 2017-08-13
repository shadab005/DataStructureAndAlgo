import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {

	ArrayList<List<Integer>> vertex;
	int n=0;
	Graph(int n){
		this.n=n;
		vertex = new ArrayList<>();
        for(int i = 0;i<n;i++)vertex.add(new ArrayList<>());
	}
	public static void main(String[] args) {
		Graph g = new Graph(9);
		g.connect(0, 2);
		g.connect(0, 3);
		g.connect(0, 5);
		g.connect(2, 3);
		g.connect(5, 8);
		g.connect(1, 6);
		g.connect(4, 7);
        printGraph(g,g.n);
        g.depthFirstTraversal();
        System.out.println("End");
	}
	boolean visited[];
	public void depthFirstTraversal(){
		int count=0;
		visited=new boolean[n];
		for(int i=0;i<n;i++){
			if(!visited[i]){
				count++;
				dfs(i);
			}
		}
		System.out.println();
		System.out.println("Number of components in graph = " + count);
	}
	
	public void dfs(int id){
		System.out.print(id + " ");
		visited[id]=true;
		for(int x:vertex.get(id)){
			if(!visited[x])dfs(x);
		}
	}
	public void connect(int first,int second){
		vertex.get(first).add(second);
		vertex.get(second).add(first);
	}
	
	private static void printGraph(Graph g, int n) {
		for(int i = 0 ; i<n ;i++){
			System.out.print(i + " :: ");
			for(int j=0;j<g.vertex.get(i).size();j++){
				System.out.print(g.vertex.get(i).get(j) +" ");
			}
			System.out.println();
		}
	}

}
