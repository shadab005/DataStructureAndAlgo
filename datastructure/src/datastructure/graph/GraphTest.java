package datastructure.graph;

public class GraphTest {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		/*g.addVertex(4);
		g.addVertex(5);*/
		/*g.addVertex(6);
		g.addVertex(7);
		g.addVertex(8);*/
		//connections
		/*g.connect(0,1);
		g.connect(0,7);
		g.connect(0,8);
		g.connect(1,2);
		g.connect(1,4);
		g.connect(2,3);
		g.connect(3,4);
		g.connect(4,5);
		g.connect(4,6);
		g.connect(5,6);
		g.connect(5,8);
		g.connect(6,7);*/
		/*g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		
		g.connect(0, 1);
		g.connect(0, 2);
		g.connect(0, 3);
		
		g.connect(1,2);
		g.connect(1, 4);
		
		g.connect(2,3);
		g.connect(2, 4);
		
		g.connect(3, 4);
		g.graphPrinter();
		
		g.allPathBetweenTwoNodes(0, 4);*/
		
		/*g.connect(0,1,20);
		g.connect(0,4,60);
		g.connect(0,5,50);
		
		g.connect(1,2,80);
		g.connect(1,5,40);
		
		g.connect(2,3,30);
		g.connect(2,5,20);
		
		g.connect(3,4,90);
		g.connect(3,5,10);
		
		g.connect(4,5,70);*/
		
		g.connect(0, 1, 5);
		g.connect(0, 2, 10);
		g.connect(1, 3, 11);
		g.connect(1, 2, 4);
		g.connect(2, 3, 5);
		g.connect(4, 5, 10);
		g.allPathBetweenTwoNodes(0, 3);
		
		/*g.graphPrinter();
		g.minimumSpanningTreePrims();*/
	}

}
