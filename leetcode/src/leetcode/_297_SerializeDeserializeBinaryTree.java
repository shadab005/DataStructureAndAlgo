package leetcode;

public class _297_SerializeDeserializeBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-1);
		root.left =  new TreeNode(0);
		root.right =  new TreeNode(1);
		//root.right.left =  new TreeNode(4);
		//root.right.right =  new TreeNode(5);
		
		
		Codec c = new Codec();
		String serializedString = c.serialize(root);
		System.out.println(serializedString);
		TreeNode deserializedTreeNode = c.deserialize(serializedString);
		String serialAgain = c.serialize(deserializedTreeNode);
		System.out.println(serialAgain);
		System.out.println(serialAgain.equals(serializedString));

		System.out.println("Done");
	}
	
	static public class Codec {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	    	if(root == null) return "";
	    	StringBuilder sb = new StringBuilder(String.valueOf(root.val));
	    	String leftTreeEncoding = serialize(root.left);
	    	String rightTreeEncoding = serialize(root.right);
	    	return sb.append("(").append(leftTreeEncoding).append(")")
	    	.append("(").append(rightTreeEncoding).append(")").toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String s) {
	      if(s.isEmpty()) return null;
	      int i = s.indexOf('(');
	      //System.out.println("Processing s = " + s);
	      int val = Integer.parseInt(s.substring(0, i));
	      TreeNode root = new TreeNode(val);
	      
	      i++;
	      int count = 1;
	      while(count!=0) {
	    	  if(s.charAt(i)=='(')count++;
	    	  else if(s.charAt(i)==')')count--;
	    	  i++;
	      }
	      String leftEncoding = s.substring(s.indexOf('(')+1,i-1);
	      String rightEnconding = s.substring(i+1, s.length()-1);
	      root.left = deserialize(leftEncoding);
	      root.right = deserialize(rightEnconding);
	      return root;   
	    }
	}
	
	

}
