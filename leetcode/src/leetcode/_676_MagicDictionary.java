package leetcode;

import java.util.Arrays;

public class _676_MagicDictionary {

	public static void main(String[] args) {
		_676_MagicDictionary m = new _676_MagicDictionary();
		String[] dict = {"hello", "leetcode"};
		m.buildDict(dict);
		System.out.println(m.search("hello"));
		System.out.println(m.search("hhllo"));
		System.out.println(m.search("leetcoded"));

	}

	Trie trie;
	
	_676_MagicDictionary() {
		trie = new Trie();
	}
	
	/** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        Arrays.stream(dict).forEach(trie::insert);
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return trie.searchWithExactlyOneModification(word);
    }
	
	
	
}
