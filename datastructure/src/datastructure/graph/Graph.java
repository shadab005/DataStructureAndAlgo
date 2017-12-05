package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	Vertex head;
	int numUsers;
	int cost[][];
	public Graph(){
		cost = new int[20][20]; //Hard coding the number of nodes 
		for(int i = 0; i < 20 ; i++)
			for(int j = 0 ; j < 20 ; j++)
				cost[i][j] = Integer.MAX_VALUE;
	}
	private class Vertex{
		int id;
		int data;
		Edge firstEdge;
		Vertex nextVertex;
		
		public Vertex(int data){
			this.data = data;
			id=numUsers;
			numUsers++;
		}

		@Override
		public String toString() {
			return "["+ id + "]";// "|" + data + "]";
		}
	}
	
	private class Edge{
		int id;
		Edge nextEdge;
		public Edge(int id){
			this.id = id;
		}
		@Override
		public String toString() {
			return "["+id+"]";
		}
	}
	
	public void initialize(){
		head = new Vertex(1);				
	}
	
	public void addVertex(int data) {
		Vertex v = new Vertex(data);
		Vertex head = this.head;
		if(head == null){
			this.head = v;
			return;
		}
		while(head.nextVertex != null) head = head.nextVertex;
		head.nextVertex = v;
	}
	
	public Vertex searchId(int id){
		Vertex head = this.head;
		while(head!=null && head.id != id) head = head.nextVertex;
		if(head!=null){
			return head;
		}
		return null;
	}
	
	public void graphPrinter(){
		Vertex head = this.head;
		if(head==null){
			System.out.println("No node found");
		}else{
			System.out.println("Number of users are : " + numUsers );
			while(head != null){
				System.out.print(head);
				if(head.firstEdge != null){
				    System.out.print(" :::> ");
					traverseEdge(head.firstEdge);
				}
				System.out.println();
				head = head.nextVertex;
			}
		}
		
	}
	
	private void traverseEdge(Edge edge) {
		while(edge!=null){
			System.out.print(edge);
			if(edge.nextEdge != null)System.out.print("-->");
			edge = edge.nextEdge;
		}
	}
	
    public int getData(Vertex v){
    	return v.data;
    }
    
    public void connect(int firstId, int secondId, int cost) {
	  this.cost[firstId][secondId] = cost;
	  this.cost[secondId][firstId] = cost;
	  connect(firstId,secondId);
	}
	
	public void connect(int firstId, int secondId) {
		
		Vertex firstVertex = searchId(firstId);
		Vertex secondVertex = searchId(secondId);
		if(firstVertex == null){
			System.out.println(firstId + " id not found");
		}else if (secondVertex == null){
			System.out.println(secondId + " id not found");
		}else if(firstId == secondId){
			System.out.println("Input ids are the same");
		}else{
			connect(firstVertex, secondId);
			connect(secondVertex, firstId);
		}
	}
	
	private void connect(Vertex vertex, int id) {
		if(vertex != null){
			Edge e = vertex.firstEdge;
			Edge newEdge = new Edge(id);
			if(e == null){
				vertex.firstEdge = newEdge;
				return;
			}
			while(e.nextEdge != null) e = e.nextEdge;
			e.nextEdge = newEdge;
		}
	}
	
	public void deleteConnection(int firstId, int secondId){
		Vertex firstVertex = searchId(firstId);
		Vertex secondVertex = searchId(secondId);
		if(firstVertex == null){
			System.out.println(firstId + " id not found");
		}else if (secondVertex == null){
			System.out.println(secondId + " id not found");
		}else if(firstId == secondId){
			System.out.println("Input ids are the same");
		}else{
			deleteConnection(firstVertex, secondId);
			deleteConnection(secondVertex, firstId);
		}
	}
	
	private void deleteConnection(Vertex vertex, int id) {
		if(vertex != null){
			Edge e = vertex.firstEdge;
			Edge prev = e;
			while(e!=null && e.id != id){
				prev = e;
				e = e.nextEdge;
			}
			if(e != null){
				if(e==prev){ //this means the first node after vertex edge is to be deleted
					vertex.firstEdge = e.nextEdge;
				}else{
					prev.nextEdge = e.nextEdge;
				}
			}
		}
	}
	
	public void deleteVertex(int id){
		Vertex head = this.head;
		Vertex prev = head;
		while(head != null && head.id != id){
			prev = head;
			head = head.nextVertex;
		}
		if(head!=null){
			Edge e = head.firstEdge;
			while(e!=null){ // furst deleting all its connection
				deleteConnection(id, e.id);
				e = e.nextEdge;
			}
			if(prev == head){
				this.head = head.nextVertex;
			}else{
				prev.nextVertex = head.nextVertex;
			}
			numUsers--;
		}
	}
	
	public boolean isConnected(int firstid, int secondId){//this is isConnected directly
		
		Vertex v = searchId(firstid);
		if(v == null) return false;
		Edge e = v.firstEdge;
		while(e != null){
			if(e.id == secondId) return true;
			e = e.nextEdge;
		}
		return false;
	}
	
	public void breadthFirstTraversal(int id){
		Vertex v = searchId(id);
		if(v==null) return;
		int visited[] = new int[numUsers];
		Queue<Integer> q = new LinkedList<>();
		q.add(v.id);
		visited[v.id] = 1;
		while(!q.isEmpty()){
			int x = q.remove();
			v = searchId(x);
			if(v != null){
				Edge e = v.firstEdge;
				while(e!=null){
					int edgeId = e.id;
					if(visited[edgeId] == 0){
						q.add(edgeId);
						visited[edgeId] = 1;
					}
					e=e.nextEdge;
				}
			}
			System.out.print(x + "  ");
		}
		System.out.println();
	}
	
	public boolean depthFirstSearch(int firstId, int secondId){
		int visited[] = new int[numUsers];
		return dfs(firstId,secondId,visited);
	}

	private boolean dfs(int firstId, int secondId, int[] visited) {
		if(firstId==secondId) return true;
		visited[firstId] = 1;
		Vertex v = searchId(firstId);
		Edge e = v.firstEdge;
		while(e!=null){
			if(visited[e.id] == 0)
			{
				boolean b = dfs(e.id, secondId, visited);
				if(b==true)return true;
			}
			e = e.nextEdge;
		}
		return false;
	}
	
	public void allPathBetweenTwoNodes(int first, int second){
		if(!depthFirstSearch(first, second)){
			System.out.println("No path between the two nodes exist");
		}
		Stack<Integer> s = new Stack<>();
		s.push(first);
		allPaths(first,second,s);
	}

	private void allPaths(int first, int second, Stack<Integer> s) {
		if(first==second){
			System.out.println(s);
			return;
		}
		Vertex v = searchId(first);
		Edge e = v.firstEdge;
		while(e!=null){
			if(depthFirstSearch(e.id, second)){
				if(!s.contains(e.id)){
				   s.push(e.id);
				   allPaths(e.id, second, s);
				   s.pop();
				}
			}
			e=e.nextEdge;
		}
	}
	
	public void shortestPath(int start, int end) {
		// distance array that calculates distance of all nodes from start
		// parent array that will be used to print path
		int distance[] = new int[numUsers];
		int parent[] = new int[numUsers];
		//initializing with -1
		intialize(distance);
		intialize(parent);
		dijkstra(start, distance, parent);
		
		Stack<Integer> s = new Stack<>();
		int element = end;
		while(element!=start){
			s.push(element);
			element = parent[element];
		}
		s.push(element);
		System.out.println("Shortest path from start to end is");
		while(!s.isEmpty()){
			System.out.print(s.pop() + " ");
		}

	}

	/*
	 * O(n^2)
	 */
	public void dijkstra(int start,int distance[], int parent[]){
		int visited[] = new int[numUsers];
		Vertex v = searchId(start);
		if(v==null) return;
		Edge e = v.firstEdge;
		if(e==null) return;
		while(e!=null){
			distance[e.id] = 1;
			parent[e.id] = start;
			e=e.nextEdge;
		}
		visited[start] = 1;
		distance[start] = 0;
		int min=0, minNode=0;
		for(int i=1;i<numUsers;i++){ 
			//This loop increaments n times and for each the internal loop increments n times. Therefore O(n2)
			min = 500;//must be actualy infinity initialy
			//selection minimum from distance matrix such that its not visited already
			for(int j=1;j<distance.length;j++){ //O(n)
				//if we maintain min priority queue this can be obtained in logn order
				if(visited[j] == 0){
					if(distance[j] < min && distance[j]>0){
						min = distance[j];
						minNode = j;
					}
				}
			}
			visited[minNode] = 1;
			Edge edge = searchId(minNode).firstEdge;
			while(edge!=null){
				if(visited[edge.id] == 0){
					if(distance[edge.id] < 0 || distance[edge.id] > distance[minNode]+1){
					   distance[edge.id] = min + 1; //min + cost[miode][this edge node]
					   parent[edge.id] = minNode;
					}
				}
				edge = edge.nextEdge;
			}
			
		}
		
	}

	private void intialize(int[] arr) {
		for(int i=0;i<arr.length;i++){
			arr[i] = -1;
		}
	}
	
	public void topologicalSort(){
	
	/*
	 A topological sort or topological ordering of a directed graph is a 
	 linear ordering of its vertices such that for every directed edge uv from vertex u to vertex v,
	 u comes before v in the ordering.  
	 
	 initialize all vertex predecessor count to 0
	 Traverse each vertex edge list and accordingly increase the predecessor count . O(n)
	 Now put all the vertex with predecesssor count 0 in queue. O(n)
	 while(!queue empty){
	   pop and print
	   traverse its edge list //This is breadth first 
	   and reduce the predecessor count
	   if count goes to zero add in queue
	 }
	 
	 
	 */
	/*
	  Another approach is to do run dfs and return vertices in reverse order
	 */
	}
	
	/*
	 * There is difference between dijstra and Prims mst
	 *  ex : 
	 *        10
	 *  a ========= b
	 *  ||         /
	 *  || 9      /
	 *  ||       /
	 *  ||     / 2
	 *  ||    /
	 *  ||  /
	 *    /
	 *   c      
	 *   
	 */
	
	/*
	 * Prims algorith start with any node
	 * And from all the edges connected with this node it select the minimum edge cost node 
	 * and connect it
	 * Now the set of edges available will be  new node added and the first node edges
	 * Now we select the minimum edge again among the set of edges and connect the node with minum edge
	 * This process conitnues until all the nodes gets connected
	 * O(n2)
	 */
	public void minimumSpanningTreePrims(){
		// will give information about the parent of a node
		int closest[] = new int[numUsers];
		 //distance of the node from parent
		int lowcost[] = new int[numUsers];
		int i = 0, min = 0, k = 0 ;
		boolean visited[] = new boolean[numUsers];
		
		for(i=1 ; i < numUsers ; i++){  
			lowcost[i] = cost[0][i];
			closest[i] = 0;
			visited[i] = false;
		}
		lowcost[0] = Integer.MAX_VALUE;
		visited[0] = true;
		
		for(i=1; i < numUsers ; i++){ 
			// when the minimum spanning tree will be formed n-1 edges will be connected.
			//Each loop connect one edge
			min = lowcost[i];
			k = i;
			for(int j = 1 ; j < numUsers ; j++){
				if(lowcost[j] < min){
					min = lowcost[j];
					k = j;
				}
			}
			lowcost[k] = Integer.MAX_VALUE;
			visited[k] = true;
			for(int j=1; j < numUsers ; j++){
				if(!visited[j] && cost[k][j] < lowcost[j]){
					lowcost[j] = cost[k][j];
					closest[j] = k;
				}
			}
			
		}
		System.out.println("Closest node");
		traverseArray(closest);
		
	}
	
	/*
	 * Sort the edges in terms if weight
	 * Pick the minimum and connect the two node with this minimum weight
	 * loop:
	 *   pick next minum if not already picked up and connect the two nodes with this edge
	 * repeat until n-1 edges are selected to connect n nodes
	 */
	public void minimumSpanningTreeKruskal(){
		
	}
	
	
	private void traverseArray(int a[]){
		for(int i = 0 ; i < a.length ; i++){
			System.out.print(a[i] + "   ");
		}
		System.out.println();
	}

}
