package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _144_PreOrderIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		if(root == null) return Collections.emptyList();
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		List<Integer> ans = new ArrayList<>();
		while(!s.isEmpty()) {
			TreeNode n = s.pop();
			ans.add(n.val);
			if(n.right!=null) s.push(n.right);
			if(n.left!=null) s.push(n.left);
		}
		return ans;
	}

}
