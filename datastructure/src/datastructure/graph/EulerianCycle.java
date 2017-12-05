package datastructure.graph;

public class EulerianCycle {

	boolean isEulerian = true;
	EulerianCycle(MyGraph g){
		
		for(int i=0;i<g.size();i++) {
			if(g.degree(i)%2!=0)isEulerian=false;
		}
	}
	
	public static void main(String[] args) {
		int n = 5;
		MyGraph g = new MyGraph(n);
		g.connect(0, 1);
		g.connect(0, 2);
		g.connect(1, 3);
		g.connect(2, 4);
		g.connect(4, 3);
		
		EulerianCycle eu = new EulerianCycle(g);
		System.out.println(eu.hasEulerCircuit());

	}
	
	public boolean hasEulerCircuit() {
		return isEulerian;
	}
	
	public void printEulerCycle(MyGraph g, int source) {
		
	}

}
