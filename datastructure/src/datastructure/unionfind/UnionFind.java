package datastructure.unionfind;
public class UnionFind {
	
	private int[] parent;  //Stores parent of id
	private int[] numChild; //Number of children of i'th node
	
	public UnionFind(int n){
		parent = new int[n];
		numChild  = new int[n];
		for(int i=0;i<n;i++)parent[i] = i;
	}
	
	public int root(int i){
		while(i!=parent[i]) i =parent[i];
		return i;
	}
	
	public int rootInPathCompression(int i){
		while(i!=parent[i]){
			parent[i]=parent[parent[i]];
			i =parent[i];
		}
		return i;
	}
	
	public boolean isConnected(int p, int q) {
		return root(p)==root(q);
	}
	
	
	public void union(int p, int q){
	  
	  int i = root(p);
	  int j = root(q);
	  if(i==j) return;
	  if(numChild[i]<numChild[j]){
		  parent[i]=j;
		  numChild[j] = numChild[j]+numChild[i]+1;
	  }else{
		  parent[j] = i;
		  numChild[i]=numChild[i]+numChild[j]+1;
	  }
	}
	
	public void traverse(){
		System.out.println("Connection array");
		for(int i: parent){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Child count");
		for(int i: numChild){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		UnionFind c =new UnionFind(9);
		c.union(0, 1);
		c.union(1, 2);
		c.union(4, 5);
		c.union(4, 1);
		c.traverse();
		System.out.println("Hello");
	}

}
