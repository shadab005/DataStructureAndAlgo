package leetcode;

import java.util.List;

public class _212_WordSearch_II {

	public static void main(String[] args) {
		
		Trie t = new Trie();
		t.insert("bad");
		t.insert("dad");
		t.insert("mad");

	}
	
	static public List<String> findWords(char[][] board, String[] words) {
		
		Trie trie = new Trie();
		for(String word : words) trie.insert(word);
		
		
		return null;
    }
	
	
	static class Trie {
		
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
		
	}

}
