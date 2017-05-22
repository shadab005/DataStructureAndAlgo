import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
	
	static ArrayList<Integer> plusOne(ArrayList<Integer> a){
		int n = a.size();
		//if(a.get(n-1)!=9)
		int i = 0;
		while(i<n &&a.get(i)==0)i++;
		if(i==n)return new ArrayList<>(Arrays.asList(1));
		if(a.get(n-1)!=9){
			a.set(n-1, a.get(n-1)+1);
		}else{
			int j = n-1;
			while(j>=0 && a.get(j)==9){
				a.set(j, 0);
				j--;
			}
			if(j>=0)a.set(j, a.get(j)+1);
			else{
				a.add(0, 1);
				return a;
			}
		}
		List<Integer> x = a.subList(i, n);
		ArrayList<Integer> y = new ArrayList<>(x);
		return y;
	}
	public static void main(String args[]){
		ArrayList<Integer> a= new ArrayList<>(Arrays.asList(0));
		System.out.println(plusOne(a));
	}

}
