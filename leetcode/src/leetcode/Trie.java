package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Trie {
	
	static class TrieNode {
		String s;
		TrieNode[] children;
		public TrieNode() {
			children = new TrieNode[26];
		}
	}
	
	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
		root.s = "";
	}
	
	public void insert(String s) {
		TrieNode node = root;
		for(char c : s.toCharArray()) {
			if(node.children[c-'a']==null) {
				node.children[c-'a'] = new TrieNode();
			}
			node = node.children[c-'a'];
		}
		node.s = s;
	}
	
	public boolean search(String s) {
		TrieNode node = root;
		for(char c : s.toCharArray()) {
			if(node.children[c-'a']==null) {
				return false;
			}
			node = node.children[c-'a'];
		}
		return node.s != null && node.s.equals(s);
	}
	
	public boolean startsWith(String s) {
		TrieNode node = root;
		for (char c : s.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				return false;
			}
			node = node.children[c - 'a'];
		}
		return true;
	}
	
	/*
	 * In this regex only '.' special character allowed
	 * '.' represents can match any character
	 */
	public boolean searchRegex(String s) {
		
		Queue<TrieNode> q = new ArrayDeque<>();
		q.add(root);
		for (char c : s.toCharArray()) {
			int qSize = q.size();
			if(qSize == 0) return false;
			for(int i = 0 ; i < qSize; i++) {
				TrieNode node = q.remove();
				if(c == '.') {
					for(int j = 0 ; j<26;j++) {
						if (node.children[j] != null) {
							q.add(node.children[j]);
						}
					}
				} else {
					if (node.children[c - 'a'] != null) {
						node = node.children[c-'a'];
						q.add(node);
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			if(q.remove().s!=null) return true;
		}
		return false;
	}
	
    public boolean searchWithExactlyOneModification(String s) {
    	
    	class ResultNode{
    		TrieNode tNode;
    		boolean isModified;
    		public ResultNode(TrieNode t) {
				tNode = t;
			}
    		public ResultNode(TrieNode t, boolean modified) {
				tNode = t;
				isModified = modified;
			}
    	}
		
		Queue<ResultNode> q = new ArrayDeque<>();
		q.add(new ResultNode(root));
		for (char c : s.toCharArray()) {
			int qSize = q.size();
			if(qSize == 0) return false;
			for(int i = 0 ; i < qSize; i++) {
				ResultNode rNode = q.remove();
				TrieNode node = rNode.tNode;
				if(rNode.isModified) {
					if (node.children[c - 'a'] != null) {
						q.add(new ResultNode(node.children[c - 'a'], rNode.isModified));
					}
				} else {
					//Not modified case
					for(int j = 0 ; j<26;j++) {
						if (node.children[j] != null) {
							q.add(new ResultNode(node.children[j], j!=(c-'a')));
						}
					}
				}
			}
		}
		while(!q.isEmpty()) {
			ResultNode node = q.remove();
			if(node.isModified && node.tNode.s != null) return true;
		}
		return false;
	}
	
}
