import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class SerializeDeserializeBinaryTreePreOrder {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		System.out.println(serialize(root));
		
		System.out.println(serialize(deserialize(serialize(root))));
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	 static public String serialize(TreeNode root) {
		 if(root==null) return "#";
		 StringBuilder sb = new StringBuilder(String.valueOf(root.val));
		 return sb.append(",").append(serialize(root.left)).append(",").append(serialize(root.right)).toString();
	 }
	 
	  static public TreeNode deserialize(String s) {
		  String[] data_array = s.split(",");
		  List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
		  return deserialize(data_list);
	  }

	private static TreeNode deserialize(List<String> l) {
		if(l.get(0).equals("#")) {
			l.remove(0);
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
		l.remove(0);
		root.left = deserialize(l);
		root.right = deserialize(l);
		return root;
	}


}
