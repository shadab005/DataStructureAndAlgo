package batman_test.shahz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	Vertex vertexList[];
	
	int count;
	Graph(int size)
	{
		vertexList = new Vertex[size];	
	}
	
	//add Vertex
	//connect
	
	void addVertex(String name){
		vertexList[count++] = new Vertex(name); 
	}
	

	void connect(int id1 , int id2)
	{
		if(id1>=count || id2 >=count){
			System.out.println("Invalid id passed");
		}
		if(!vertexList[id1].edgeList.contains(id2) && !vertexList[id2].edgeList.contains(id1))
		{
			vertexList[id1].edgeList.add(id2);
			vertexList[id2].edgeList.add(id1);
		}else{
			System.out.println("Two vertex are already connected");
		}
	}
	
	private static void printGraph(Graph g, int n) {
		for(int i = 0 ; i<n ;i++){
			System.out.print(i + " :: ");
			for(int j=0;j<g.vertexList[i].edgeList.size();j++){
				System.out.print(g.vertexList[i].edgeList.get(j) +" ");
			}
			System.out.println();
		}
	}
	
	void bfs(int id){
		boolean visited[] =  new boolean[vertexList.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(id);
		visited[id]=true;
		while(!q.isEmpty()){
			int x = q.poll();
			System.out.print(x + " ");
			for(int edgeId:vertexList[x].edgeList){
				if(!visited[edgeId]){
					q.add(edgeId);
					visited[edgeId]=true;
				}
			}
		}
		System.out.println();
		
	}
	
	boolean visited[];
	void dfs(int id)
	{
		visited = new boolean[count];
		dFS(id);
		System.out.println();
	}
	
	
	private void dFS(int id) {
		System.out.print(id + " ");
		visited[id] = true;
		for(int edgeid : vertexList[id].edgeList)
		{
			if(!visited[edgeid])
				dFS(edgeid);
		}
	}
	
	private int components ;
	private void depthFirstTraversal() {
		components = 0;
		visited = new boolean[count];
		for(int i = 0; i < count ; i++)
		{
			if(!visited[i]){
				components++;
				dFS(i);
			}
		}
		System.out.println();
	}
	
	void components()
	{
		depthFirstTraversal();
		System.out.println("Components : " + components);
	}

	public static void main(String[] args) {

		Graph g = new Graph(10);
		g.addVertex("0");
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		g.addVertex("5");
		g.addVertex("6");
		g.addVertex("7");
		g.addVertex("8");
		g.addVertex("9");
		g.connect(0, 2);
		g.connect(0, 3);
		g.connect(0, 5);
		g.connect(2, 3);
		g.connect(5, 8);
		g.connect(1, 6);
		g.connect(4, 7);
		g.connect(1, 2);
		g.connect(3, 4);
		//g.connect(8, 9);
		
		printGraph(g, 10);
		System.out.println("Bfs");
		g.bfs(0);
		//g.dfs(0);
		
		//g.depthFirstTraversal();
		g.components();
		
	}
	
	
	static class Vertex{
		String name;
		ArrayList<Integer> edgeList;
		Vertex(String name)
		{
			this.name = name;
			edgeList = new ArrayList<>();
		}
	}

}
