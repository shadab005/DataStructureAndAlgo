import java.util.ArrayList;


/*
 * https://www.interviewbit.com/problems/unique-binary-search-trees/
    1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 */
public class UniqueBinarySearchTree {

	ArrayList<TreeNode> dp[][];
	int count = 0 ;
	@SuppressWarnings("unchecked")
	public ArrayList<TreeNode> generateTrees(int n) {
        dp = (ArrayList<TreeNode>[][])new ArrayList[n+1][n+1];
		ArrayList<TreeNode> nodes =  generateTree(1,n);
		//System.out.println("Count = " + count);
		//System.out.println("Size = " + nodes.size());
		
		return nodes;

	}

	private ArrayList<TreeNode> generateTree(int s, int e) {
		//System.out.println("Calling generateTree " + s + ", " + e);
		if(s>e)return null;
		if(dp[s][e]!=null)return dp[s][e];
		//System.out.println("Generating");
		ArrayList<TreeNode> nodes = new ArrayList<>();
		TreeNode node = null;
		for(int i=s;i<=e;i++) {
			ArrayList<TreeNode> left = generateTree(s, i-1);
			ArrayList<TreeNode> right = generateTree(i+1, e);
			//if(left!=null)System.out.println("Left size " + left.size());
			//if(right!=null)System.out.println("Right size " + right.size());
			
			if(left!=null && right!=null) {
				for(TreeNode l : left) {
					for(TreeNode r: right) {
						node = new TreeNode(i);
						node.left = l;
						node.right = r;
						nodes.add(node);
					}
				}
			}else if(left==null && right!=null) {
				for(TreeNode r: right) {
					node = new TreeNode(i);
					node.left = null;
					node.right = r;
					nodes.add(node);
				}
			}else if(right==null && left!=null){
				for(TreeNode l: left) {
					node = new TreeNode(i);
					node.left = l;
					node.right = null;
					nodes.add(node);
				}
			}else {
				nodes.add(new TreeNode(i));
			}
			
		}
		dp[s][e]=nodes;
		count++;
		return nodes;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTree u = new UniqueBinarySearchTree();
		u.generateTrees(7);
	}

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
