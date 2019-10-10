package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _133_CloneGraph {

	private static class Node {
		public int val;
		public List<Node> neighbors;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public Node cloneGraph(Node node) {
		Map<Node, Node> cloneNodeMap = new HashMap<>();
		return dfs(node, cloneNodeMap);
	}

	private static Node dfs(Node node, Map<Node, Node> cloneNodeMap) {
		if (cloneNodeMap.containsKey(node))return cloneNodeMap.get(node);
		Node newNode = new Node();
		newNode.val = node.val;
		newNode.neighbors = new ArrayList<>();
		cloneNodeMap.put(node, newNode);
		for (Node child : node.neighbors) newNode.neighbors.add(dfs(child, cloneNodeMap));
		return newNode;
	}

}
