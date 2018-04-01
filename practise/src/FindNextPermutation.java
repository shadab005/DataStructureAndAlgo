import java.util.ArrayList;
import java.util.Arrays;

public class FindNextPermutation {

	public void nextPermutation(ArrayList<Integer> a) {
		int n= a.size();
		if(n==0 || n==1)return;
		int i=n-2;
		
		while(i>=0 && a.get(i)>=a.get(i+1)) {
			i--;
		}
		if(i<0) {
			//Elements are in decending order
			//reverse array from index 0 to n-1
			reverseList(a, 0, n-1);
		}else {
			int j=i+1;
			while(j<n && a.get(j)>a.get(i)) {
				j++;
			}
			j--;
			//swap i and jth element
			Integer temp  = a.get(i);
			a.set(i, a.get(j));
			a.set(j, temp);
			//now reverse i+1 to n-1 index
			reverseList(a, i+1, n-1);
		}
		
	}
	
	public void reverseList(ArrayList<Integer> a , int startIndex, int endIndex) {
		Integer temp = 0;
		while(startIndex<endIndex) {
			//swap element at start index and end index
			temp  = a.get(startIndex);
			a.set(startIndex, a.get(endIndex));
			a.set(endIndex, temp);
			startIndex++;
			endIndex--;
		}
	}
	
	public static void main(String[] args) {
		Integer a[] = {626, 436, 819, 100, 382, 173, 817, 581, 220, 95, 814, 660, 
				397, 852, 15, 532, 564, 715, 179, 872, 236, 790, 223, 379, 83, 924, 
				454, 846, 742, 730, 689, 112, 110, 516, 85, 149, 228, 202, 988, 212,
				69, 602, 887, 445, 327, 527, 347, 906, 54, 460, 517, 376, 395, 494, 
				827, 448, 919, 799, 133, 879, 709, 184, 812, 514, 976, 700, 156, 
				568, 453, 267, 547, 8, 951, 326, 652, 772, 213, 714, 706, 972, 
				318, 768, 506, 59, 854, 422 };
		ArrayList<Integer> l= new ArrayList<Integer>(Arrays.asList(a));
		System.out.println(l);

	}

}
