package leetcode;

public class _979_DistributeCoins {

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(2);
		System.out.println(distributeCoins(root));
	}

	static int moveCount = 0;

	static public int distributeCoins(TreeNode root) {
		moveCount = 0;
		solve(null, root);
		return moveCount;
	}

	// Return the extra counts at root
	static int solve(TreeNode parent, TreeNode root) {

		if (root == null)
			return 0;

		int leftExtra = solve(root, root.left);
		int rightExtra = solve(root, root.right);
		root.val += leftExtra + rightExtra;
		if (root.val == 1) {
			return 0;//leftExtra + rightExtra;
		} else if (root.val < 1) {
			// pull it from parent
			int pullCoinCount = 1 - root.val;
			if (parent != null) {
				parent.val = parent.val - pullCoinCount;
			}
			moveCount += pullCoinCount;
			return 0;
		}else if(root.val > 1) {
			int extra = root.val - 1;
			moveCount += extra;
			return extra;
		}
		return 0;
	}

	
	//initalize moveCount everytime before calling this method
	public int distributeCoinsNew(TreeNode root) {
		if (root == null) {
            return 0;
        }
		int leftCoinCountExtraOrDeficient = distributeCoinsNew(root.left);
		int rightCointExtraOrDeficient = distributeCoinsNew(root.right);
		moveCount+=Math.abs(leftCoinCountExtraOrDeficient)+Math.abs(rightCointExtraOrDeficient);
		return root.val + leftCoinCountExtraOrDeficient + rightCointExtraOrDeficient - 1;
    }
}
