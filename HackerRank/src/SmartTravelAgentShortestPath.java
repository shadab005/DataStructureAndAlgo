import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SmartTravelAgentShortestPath {

	public static void main(String[] args) {
	  Scanner in = new Scanner(System.in);
	  int n = in.nextInt();
	  int r = in.nextInt();
	  WeightedGraph g = new WeightedGraph(n+1);
	  while(r-->0) {
		  g.addEdge(new Edge(in.nextInt(), in.nextInt(),in.nextInt()));
	  }
	  int source = in.nextInt();
	  int destination = in.nextInt();
	  int totalTourists = in.nextInt();
	  computeMinTripCount(g, source, destination, totalTourists);
	  in.close();

	}
	
	static void computeMinTripCount(WeightedGraph g, int source, int destination, int totalTourists) {
		//System.out.println(g);
		//System.out.println("source = " + source + " destination = " + destination +" total = " + totalTourists);
		int n = g.n();
		Comparator<Edge> byWeight = (o1,o2)->o2.weight-o1.weight;
		PriorityQueue<Edge> pq = new PriorityQueue<>(byWeight);
		int closest[] = new int[n];
	   	int cost[] = new int[n];
	   	Arrays.fill(cost, -1);
	   	Arrays.fill(closest, -1);
	   	cost[source]=Integer.MAX_VALUE;
	   	closest[source]=source;
	   	boolean visited[] = new boolean[n];
	   	visited[source]=true;
	   	for(Edge e: g.adj(source)) {
	   		closest[e.other(source)]=source;
	   		cost[e.other(source)]=e.weight();
	   		pq.add(e);
	   	}
	   	boolean found = false;
	   	Edge e = null;
	   	int u = 0, v = 0, temp = 0;
	   	for(int i=1; i < n ; i++){
	   		found = false;
	   		while(!found) {
	   			e = pq.remove();
	   			u = e.either();
	   			v = e.other(u);
	   			if(!visited[u]) {
	   	   			found = true;
	   	   			temp = u;
	   	   			u = v; //Making u as parent of v
	   	   			v = temp; 
	   	   		}else if(!visited[v]) {
	   	   			found = true;
	   	   		}
	   		}
	   		//u is parent of v and v is the new found node selected
	   		visited[v]=true;
	   		//update the cost of v which will tell us how much quantity has been accomodated
	   		cost[v] = Math.min(e.weight, cost[u]);
	   		if(v==destination)break;
	   		
	   		for(Edge edge:g.adj(v)) {
	   			if(!visited[edge.other(v)]) {
	   				int w = edge.other(v);
	   				if(cost[w]<Math.min(cost[v], edge.weight)) {
	   					closest[w] = v;
	   					cost[w] = Math.min(cost[v], edge.weight);
	   					pq.add(new Edge(v,w,Math.min(cost[v], edge.weight)));
	   				}
	   			}
	   		}
	   		/*System.out.println("cost");
	   		Util.printArray(cost);
	   		System.out.println("Parent");
	   		Util.printArray(closest);*/
	   	}
	   	ArrayDeque<Integer> stack = new ArrayDeque<>();
	   	stack.add(destination);
	   	int z = closest[destination];
	   	while(z!=source) {
	   		stack.add(z);
	   		z = closest[z];
	   	}
	   	stack.add(source);
	   	while(!stack.isEmpty()) {
	   		System.out.print(stack.removeLast() +" ");
	   	}
	   	//System.out.println(stack);
	   	System.out.println();
	   	cost[destination]--;
	   	long ans = (totalTourists)/cost[destination];
	   	if((totalTourists)%cost[destination]!=0)ans++;
	   	System.out.println(ans);
	}


	static class WeightedGraph {

		private int n = 0; // No. of vertices
		private int e = 0; // No. of edges
		private ArrayList<Edge>[] vertex;

		@SuppressWarnings("unchecked")
		public WeightedGraph(int n) {
			if (n < 0)
				throw new IllegalArgumentException("Number of vertices must be nonnegative");
			this.n = n;
			vertex = (ArrayList<Edge>[]) new ArrayList[n];
			for (int v = 0; v < n; v++) {
				vertex[v] = new ArrayList<Edge>();
			}
		}
		
		public Iterable<Edge> adj(int v){
			return vertex[v];
		}

		public int edgeCount() {
			return e;
		}

		public int n() {
			return n;
		}

		public int degree(int v) {
			return vertex[v].size();
		}

		public void addEdge(Edge edge) {
			int v = edge.either();
			int w = edge.other(v);
			vertex[v].add(edge);
			vertex[w].add(edge);
			e++;
		}

		public Iterable<Edge> edges() {
			ArrayList<Edge> list = new ArrayList<Edge>();
			for (int v = 0; v < n; v++) {
				int selfLoops = 0;
				for (Edge e : vertex[v]) {
					if (e.other(v) > v) {
						list.add(e);
					}
					// add only one copy of each self loop (self loops will be consecutive)
					else if (e.other(v) == v) {
						if (selfLoops % 2 == 0)
							list.add(e);
						selfLoops++;
					}
				}
			}
			return list;
		}
		
		public String toString() {
			String NEWLINE = System.getProperty("line.separator");
			StringBuilder s = new StringBuilder();
			s.append(n + " " + e + NEWLINE);
			for (int v = 0; v < n; v++) {
				s.append(v + ": ");
				for (Edge e : vertex[v]) {
					if(v < e.other(v))
					s.append(e + "  ");
				}
				s.append(NEWLINE);
			}
			return s.toString();
		}

	}
	
	static class Edge implements Comparable<Edge> {

		private final int weight;
		private final int v;
		private final int w;

		public Edge(int v, int w, int weight) {
			this.weight = weight;
			this.v = v;
			this.w = w;
		}

	  //Weight of the edge
	   public int weight() {
			return weight;
		}
		
		public int either() {
	        return v;
	    }
		
		public int other(int vertex) {
	        if      (vertex == v) return w;
	        else if (vertex == w) return v;
	        else throw new IllegalArgumentException("Illegal endpoint");
	    }
		
		public String toString() {
	        return String.format("%d---%d %d", v, w, weight);
	    }

		@Override
		public int compareTo(Edge that) {
			return this.w -  that.w;
		}

	}


}
