public class ConnectionProblem {
	
	private int[] id;  //Stores parent of id
	private int[] numChild;
	
	public ConnectionProblem(int n){
		id = new int[n];
		numChild  = new int[n];
		for(int i=0;i<n;i++)id[i] = i;
	}
	
	public int root(int i){
		while(i!=id[i]) i =id[i];
		return i;
	}
	
	public int rootInPathCompression(int i){
		while(i!=id[i]){
			id[i]=id[id[i]];
			i =id[i];
		}
		return i;
	}
	
	
	public void union(int p, int q){
	  
	  int i = root(p);
	  int j = root(q);
	  if(i==j) return;
	  if(numChild[i]<numChild[j]){
		  id[i]=j;
		  numChild[j] = numChild[j]+numChild[i]+1;
	  }else{
		  id[j] = i;
		  numChild[i]=numChild[i]+numChild[j]+1;
	  }
	}
	
	public void traverse(){
		System.out.println("Connection array");
		for(int i: id){
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
		ConnectionProblem c =new ConnectionProblem(9);
		c.union(0, 1);
		c.union(1, 2);
		c.union(4, 5);
		c.union(4, 1);
		c.traverse();
		System.out.println("Hello");
	}

}
