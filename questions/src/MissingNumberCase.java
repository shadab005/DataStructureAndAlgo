
public class MissingNumberCase {

	/*
	 *si: 1 2 3 4 .. n
	 *ai  a1,a2, .. an-1
	 *miss: summation(si)-summation(ai)
	 *or missing = summation(si-ai) + n
	 */
	static int findMissingNumber(int a[]){
		int i = 0;
		int miss=0;
		for(i=0;i<a.length;i++){
			miss=miss+(i+1)-a[i];
		}
		miss=miss+(i+1);
		return miss;
	}
	
	/*
	 * Another method is to xor from 1 to n
	 * and then xor with all a[i] 
	 */
	public static void main(String[] args) {
		int a[]= {4,3,2,5};
		System.out.println(findMissingNumber(a));

	}

}
