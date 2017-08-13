package batman_test.shahz;

public class GraphM {

	boolean graph[][];
	Node[] nodes;
	int count;
	public GraphM(int size) {
	  graph = new boolean[size][size];
	  nodes = new Node[size];
	}
	
	void addNode(String name)
	{
		nodes[count++] = new Node(name);
	}
	
	void connect(int id1, int id2){
		if(id1>=count || id2>=count)System.out.println("Invalid node id");
		else{
		graph[id1][id2]=true;
		graph[id2][id1]=true;
		}
	}
	
	static class Node{
		String name;
		public Node(String name) {
			this.name=name;
		}

	}
}
