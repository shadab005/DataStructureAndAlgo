package leetcode;

public class _124_BinaryTreeMaximumPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int ans = 0;
	 public int maxPathSum(TreeNode root) {
	        ans = root.val;
	        
	        calculateMaxSumPath(root);
	        
	        return ans;
	 }
	private int calculateMaxSumPath(TreeNode root) {
		if(root==null) return Integer.MIN_VALUE;
		ans = Math.max(ans, root.val);
		int left  = calculateMaxSumPath(root.left);
		int right  = calculateMaxSumPath(root.right);
		
		if(left!= Integer.MIN_VALUE && right!=Integer.MIN_VALUE) {
			ans = Math.max(ans, root.val+left+right);
			ans = Math.max(ans, left+root.val);
			ans = Math.max(ans, right+root.val);
			return Math.max(root.val, root.val+Math.max(left, right));
		}
		if(left!=Integer.MIN_VALUE) {
			ans = Math.max(ans, left+root.val);
			return Math.max(root.val, root.val+left);
		}
		if(right!=Integer.MIN_VALUE) {
			ans = Math.max(ans, right+root.val);
			return Math.max(root.val, root.val+right);
		}
		return root.val;
		
	}
}
