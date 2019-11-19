package leetcode;

import java.util.HashSet;

public class _968_BinaryTreeCameras {

	public static void main(String[] args) {
		
		
	}
	
	static int count = 0;
	static HashSet<TreeNode> inCameraLight;
	static public int minCameraCover(TreeNode root) {
		inCameraLight = new HashSet<>();
		inCameraLight.add(null);
        count = 0;
		solve(null, root);
		return count;
    }
	
	public static void solveAgain(TreeNode parent, TreeNode root) {
		if(root == null) return;
		solveAgain(root, root.left);
		solveAgain(root, root.right);
		if((parent == null && !inCameraLight.contains(root))
				||!inCameraLight.contains(root.left) 
				|| !inCameraLight.contains(root.right)) {
			count++;
			inCameraLight.add(root);
			inCameraLight.add(root.left);
			inCameraLight.add(root.right);
			inCameraLight.add(parent);
		}
	}

	
	private static void solve(TreeNode parent, TreeNode root) {
		if(root == null) return;
		solve(root, root.left);
		solve(root, root.right);
		if(inCameraLight.contains(root.left) || inCameraLight.contains(root.right)) inCameraLight.add(root);
		if(root.val == 1) { //Already camera put
			if(root.left != null) inCameraLight.add(root.left);
			if(root.right != null) inCameraLight.add(root.right);
			inCameraLight.add(root);
			if(parent!=null) inCameraLight.add(parent);
		} else if(isLeaf(root)) { //leaf node
			if(parent == null) {
				inCameraLight.add(root);
				count = 1;
			} else if(parent.val==0) {
				parent.val = 1;
				count++;
			}
		} else {
			if(!eitherChildHasCamera(root)) {
				//give camera to parent
				if(parent != null && parent.val == 0) {
					parent.val = 1;
					count++;
					inCameraLight.add(root);
					inCameraLight.add(parent);
				} else if(parent == null) {
					installCameraAtRoot(root, parent);
				}
			}
			if(!bothChildInCameraLight(root)) {
				installCameraAtRoot(root, parent);
			}
		}
		
	}
	
	private static void installCameraAtRoot(TreeNode root, TreeNode parent) {
		root.val = 1;
		count++;
		if(root.left != null) inCameraLight.add(root.left);
		if(root.right != null) inCameraLight.add(root.right);
		inCameraLight.add(root);
		if(parent!=null) inCameraLight.add(parent);
		
	}
	
	private static boolean eitherChildHasCamera(TreeNode root) {
		if(root.left !=null && root.left.val ==1) return true;
		if(root.right!=null && root.right.val ==1) return true;
		return false;
	}


	private static boolean bothChildInCameraLight(TreeNode root) {
		if(root.left != null) {
			if(!inCameraLight.contains(root.left)) {
				return false;
			}
		}
		if(root.right != null) {
			if(!inCameraLight.contains(root.right)) {
				return false;
			}
		}
		return true;
	}


	public static boolean isLeaf(TreeNode root) {
		return root!=null && root.left == null && root.right == null;
	}

}
