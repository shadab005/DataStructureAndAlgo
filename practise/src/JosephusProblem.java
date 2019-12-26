import java.util.Scanner;

/*
 * https://qr.ae/Te7yF5
 * https://youtu.be/uCsD3ZGzMgE
 */

/*
* Suppose 𝑓(𝑛,𝑘) is the solution the problem and he is the lucky guy that ultimately lives .
* Lucky guy (starting from first iteration)= lucky guy (starting from second iteration)
* The lucky guy doesn’t change from iteration to iteration but his index from round to round changes.
* Let us change the indexing system from[1𝑡𝑜𝑛] to[0𝑡𝑜𝑛−1]for simplicity in programming and understanding.
* now in the first iteration (𝑘−1)𝑡ℎ person is killed, the remaining number of persons are 𝑛−1.
* 
* Now for the second iteration of killing , let us look at the change in the indexing system (first iteration 𝑁persons alive, second iteration 𝑁−1persons alive)
* first iteration —->0,1,2,3,…,𝑘−1,𝑘,𝑘+1,…,𝑁−2,𝑁−1 (k-1 th person killed)
* for second iteration the indexing starts from 𝑘.
* kth person in first iteration will be 0th person in second iteration.
* 𝑘+1th person first iteration will be in 1st position in second iteration.
* similarly, If𝑓(𝑛−1,𝑘) is the solution and index of lucky guy in second iteration then his index in first iteration would be ((𝑘+𝑓(𝑛−1,𝑘))
* (remainder is taken so as to limit the indices below N )
* (𝑎is remainder obtained when 𝑎is divided by 𝑏).
* Thus we obtain the recursive relation
* 𝑓(𝑛,𝑘)=(𝑓(𝑛−1,𝑘)+𝑘)
* this gives the solution in 0 indexing system, to get answer in 1 indexing system add 1 to the solution.
*/
public class JosephusProblem {

	public static void main(String[] args) {
		//System.out.println(josephus(50,10));
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0) {
			System.out.println(josephus(in.nextInt(), in.nextInt()));
		}
		in.close();

	}
	
	static int josephus(int n, int k) {
		return 1+JosephusHelper(n,k);
	}
	
	static int JosephusHelper(int n,int k)
	{
		if(n==1) return 0;  // if there is only one person his index is 0
		return ((JosephusHelper(n-1,k)+k)%n); 
	} 
	
	//returns log a to the base b
	static int log(int a, int b) {
		return (int)(Math.log(a)/Math.log(b));
	}

}
