import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return null;
		HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode root = copyOf(node,map); 
		
		UndirectedGraphNode xNode = null, yNode = null;
		HashSet<UndirectedGraphNode> visited = new HashSet<>();
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		q.add(node);
		visited.add(node);
		while(!q.isEmpty()) {
		   	xNode = q.remove();
		   	yNode = copyOf(xNode, map);
		   	for(UndirectedGraphNode n:xNode.neighbors) {
		   		yNode.neighbors.add(copyOf(n, map));
		   		if(!visited.contains(n)) {
		   			visited.add(n);
		   			q.add(n);
		   		}
		   	}
		}		
		return root;
	}

	private UndirectedGraphNode copyOf(UndirectedGraphNode node, HashMap<UndirectedGraphNode,UndirectedGraphNode> map) {
		if(map.containsKey(node))return map.get(node);
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		return copy;
	}
}
