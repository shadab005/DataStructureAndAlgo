package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

import leetcode.Trie.TrieNode;

public class _745_PrefixAndSuffixSearch {

	public static void main(String[] args) {
		_745_PrefixAndSuffixSearch s = new _745_PrefixAndSuffixSearch(new String[] {"apple"});
		System.out.println(s.f("a", "e"));
	}

	private String w[];
	Trie t;

	public _745_PrefixAndSuffixSearch(String[] words) {
		w = words;
		t = new Trie();
		buildTrie();
	}

	public int f(String prefix, String suffix) {
		String key = suffix + "#" + prefix;
		TrieNode node = t.root;
		for (char c : key.toCharArray()) {
			if (c == '#') {
				if (node.children[26] == null) {
					return -1;
				}
				node = node.children[26];
			} else {
				if (node.children[c - 'a'] == null) {
					return -1;
				}
				node = node.children[c - 'a'];
			}
		}
		return node.cost;
	}

	private void buildTrie() {
		int cost = 0;
		for (String s : w) {
			//System.out.println("Processing " + s);
			int i = s.length();
			while (i >= 0) {
				String p = s.substring(i) + "#" + s;
				//System.out.println(p);
				t.insert(p, cost);
				i--;
			}
			cost++;
		}

	}

	static class TrieNode {
		String s;
		TrieNode[] children;
		public int cost;

		public TrieNode() {
			children = new TrieNode[27];
			cost = -1;
		}
	}

	static class Trie {

		
		TrieNode root;

		public Trie() {
			root = new TrieNode();
			root.s = "";
		}

		public void insert(String s, int cost) {
			TrieNode node = root;
			for (char c : s.toCharArray()) {
				if (c == '#') {
					if (node.children[26] == null) {
						node.children[26] = new TrieNode();
					}
					node = node.children[26];
					node.cost = cost;
				} else {
					if (node.children[c - 'a'] == null) {
						node.children[c - 'a'] = new TrieNode();
					}
					node = node.children[c - 'a'];
					node.cost = cost;
				}
			}
			node.s = s;
			node.cost = cost;
		}

		public boolean search(String s) {
			TrieNode node = root;
			for (char c : s.toCharArray()) {
				if (c == '#') {
					if (node.children[26] == null) {
						return false;
					}
					node = node.children[26];
				} else {
					if (node.children[c - 'a'] == null) {
						return false;
					}
					node = node.children[c - 'a'];
				}
			}
			return node.s != null && node.s.equals(s);
		}

	}

}
