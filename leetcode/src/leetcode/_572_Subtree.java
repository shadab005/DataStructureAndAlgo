package leetcode;

public class _572_Subtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSubtree(TreeNode s, TreeNode t) {

		if(s== null || t == null) return false;
		String ss = serialize(s);
		String tt = serialize(t);
		return search(tt, ss)!=-1;
	}
	
	public String serialize(TreeNode root) {
    	if(root == null) return "";
    	StringBuilder sb = new StringBuilder("["+String.valueOf(root.val)+"]");
    	String leftTreeEncoding = serialize(root.left);
    	String rightTreeEncoding = serialize(root.right);
    	return sb.append("(").append(leftTreeEncoding).append(")")
    	.append("(").append(rightTreeEncoding).append(")").toString();
    }
	
	int search(String pattern, String text) {
	    int[] lsp = computeLspTable(pattern);
	    
	    int j = 0;  // Number of chars matched in pattern
	    for (int i = 0; i < text.length(); i++) {
	        while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
	            // Fall back in the pattern
	            j = lsp[j - 1];  // Strictly decreasing
	        }
	        if (text.charAt(i) == pattern.charAt(j)) {
	            // Next char matched, increment position
	            j++;
	            if (j == pattern.length())
	                return i - (j - 1);
	        }
	    }
	    
	    return -1;  // Not found
	}
	
	int[] computeLspTable(String pattern) {
	    int[] lsp = new int[pattern.length()];
	    lsp[0] = 0;  // Base case
	    for (int i = 1; i < pattern.length(); i++) {
	        // Start by assuming we're extending the previous LSP
	        int j = lsp[i - 1];
	        while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
	            j = lsp[j - 1];
	        if (pattern.charAt(i) == pattern.charAt(j))
	            j++;
	        lsp[i] = j;
	    }
	    return lsp;
	}

}
