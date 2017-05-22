import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		RandomizedQueue<String> rq = new RandomizedQueue<>();
		int count = 0;
        while(!StdIn.isEmpty()){
        	if(count!=k){
        		rq.enqueue(StdIn.readString());
        		count++;
        	}else{
        		rq.enqueue(StdIn.readString());
        		rq.dequeue();
         	}
        }
        for(int i = 0; i < k; i++){
    		StdOut.println(rq.dequeue());
    	}
	}
}