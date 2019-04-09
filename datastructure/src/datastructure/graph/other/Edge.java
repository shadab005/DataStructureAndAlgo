package datastructure.graph.other;

public class Edge implements Comparable<Edge> {

	private final double weight;
	private final int v;
	private final int w;

	public Edge(int v, int w, double weight) {
		this.weight = weight;
		this.v = v;
		this.w = w;
	}

  //Weight of the edge
   public double weight() {
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
        return String.format("%d---%d %.5f", v, w, weight);
    }

	/*
	 * Comparing weight of edges
	 */
	@Override
	public int compareTo(Edge that) {
		return Double.compare(this.w, that.w);
	}
	
	public static void main(String[] args) {
        Edge e = new Edge(12, 34, 5.67);
        System.out.println(e);
    }

}
