import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		System.out.println("Start");

		final List<String> l = new ArrayList<String>();

		l.add("sd");
		System.out.println(l);
		System.out.println("End");

	}

	Node head;

	public Node cloneLLwithRandomPointer() {
		// origNode,CopyNode
		Map<Node, Node> map = new HashMap<>();
		Node h1 = head;
		Node h2 = null;
		while (h1 != null) {
			boolean existNode = checkInMap(map, h1);
			if (!existNode) {
				h2 = new Node(h1.data);
				map.put(h1, h2);
			}

			if (h1.next != null) {
				boolean existsNext = checkInMap(map, h1.next);
				if (!existsNext) {
					h2.next = new Node(h1.next.data);
					map.put(h1.next, h2.next);
				} else {
					h2.next = map.get(h1.next);
				}
			}

			if (h1.random != null) {
				boolean existsRandom = checkInMap(map, h1.random);
				if (!existsRandom) {
					h2.random = new Node(h1.random.data);
					map.put(h1.random, h2.random);
				} else {
					h2.random = map.get(h1.random);
				}

			}

			h1 = h1.next;
			h2 = h2.next;
		}
		return h2;
	}

	public boolean checkInMap(Map<Node, Node> map, Node h1) {
		for (Map.Entry<Node, Node> entry : map.entrySet()) {
			if (h1 == entry.getKey())
				return true;
		}
		return false;
	}

	static class Node {
		Node(int x) {
			data = x;
		}
		int data;
		Node next;
		Node random;
	}

}