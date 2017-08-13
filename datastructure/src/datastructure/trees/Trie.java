package datastructure.trees;

public class Trie {

	public TrieNode root;
	Trie(){root=new TrieNode();root.data="";}
	
	public void insert(String word) {
		TrieNode node = root;
		 for(char c: word.toCharArray()){
			 if(node.children[c-'a']==null){
				 node.children[c-'a']=new TrieNode();
			 }
			 node=node.children[c-'a'];
		 }
		 node.data=word;
	}
	
	public boolean search(String key){
		TrieNode node = root;
		for(char c: key.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
		if(node.data != null && node.data.equals(key)) return true;
		else return false;
	}
	
	public void deleteNode(String word){
		TrieNode node = root;
		//TrieNode prev = root;
		for(char c: word.toCharArray()){
            if(node.children[c-'a']==null)return;
            //prev = node;
            node = node.children[c-'a'];
        }
		node.data = null;
		//ideally if all the children are null then this node should be dropped and
		// it applies for all the previous node along the path
		//To solve this we can keep the count of children in the node information 
		//if count is 0 drop the node
		//To keep track of all previous node keep stack
		
	}
	
	public static void main(String[] args) {
		
		Trie t = new Trie();
		t.insert("a");
		t.insert("shadab");
		t.insert("sud");
		t.insert("shebi");
		System.out.println(t.search("shad"));

	}

}

class TrieNode{
	String data=null;
	public TrieNode[] children = new TrieNode[26];
}
