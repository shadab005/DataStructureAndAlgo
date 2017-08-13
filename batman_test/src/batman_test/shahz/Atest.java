package batman_test.shahz;

import java.util.ArrayList;

public class Atest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> listoflist = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(10);
		list1.add(20);
		
		listoflist.add(list1);
		
		System.out.println(listoflist.get(0));
		
	}
	
	void fun(int x, int y){
		System.out.println(x+"  + y");
	}

}
