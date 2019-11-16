package datastructure.graph;

import java.util.ArrayList;

public class MyGraph {

	private int n = 0;
	//Graph using array of ArrayList
	public ArrayList<Integer>[] vertex;
	
	@SuppressWarnings("unchecked")
	public MyGraph(int n){
		this.n = n;
		ArrayList<Integer>[] a = (ArrayList<Integer>[])new ArrayList[n];
		for(int i=0;i<n;i++)a[i]=new ArrayList<>();
		this.vertex = a;
	}
	
	public void connect(int v, int w) {
		vertex[v].add(w);
		vertex[w].add(v);
	}
	
	public Iterable<Integer> adj(int v){
		return vertex[v];
	}
	
	public int size() {
		return n;
	}
	
	public int degree(int v) {
        return vertex[v].size();
    }
	
	public static void main(String[] args) {
		

	}

}
