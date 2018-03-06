
public class MaxSumPathBinaryTree {

	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val=x;}
	}
	
	int max = 0;
	public int maxPathSum(TreeNode root) {
	   max = Integer.MIN_VALUE;
	   maxSum(root);
       return max;
	}
	
	private int maxSum(TreeNode root) {
		if(root==null)return 0;
		int left = maxSum(root.left);
		int right = maxSum(root.right);
		max=Math.max(max, Math.max(root.val, root.val+right+left));
		return Math.max(root.val,root.val+Math.max(left, right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
