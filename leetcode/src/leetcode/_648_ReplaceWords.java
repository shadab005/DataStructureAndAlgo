package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _648_ReplaceWords {

	public static void main(String[] args) {
		System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
	}
	
	static public String replaceWords(List<String> dict, String sentence) {
		Trie t = new Trie();
		dict.forEach(t::insert);
		Scanner in = new Scanner(sentence);
		StringBuilder sb = new StringBuilder();
		while(in.hasNext()) {
			sb.append(t.find(in.next()));
			sb.append(" ");
		}
		in.close();
		return sb.toString().trim();
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
		
		public String find(String s) {
			TrieNode node = root;
			for(char c : s.toCharArray()) {
				if(node.children[c-'a']==null) {
					return s;
				}
				node = node.children[c-'a'];
				if(node.s!=null) return node.s;
			}
			return s;
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
