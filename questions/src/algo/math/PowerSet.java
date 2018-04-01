package algo.math;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet {

	/*
	 * Recursive solution
	 */
	private static ArrayList<Integer> subsetList;
	private static void printPowerSet(int a[], int index){
		if(index == a.length){
			if(subsetList.isEmpty())System.out.print("Empty Set");
			for(int x : subsetList)System.out.print(x + " ");
			System.out.println();
			return;
		}
		Integer z = a[index];
		printPowerSet(a,index+1); // Recursive call when element at index is not the part of subset
		subsetList.add(z);
		printPowerSet(a,index+1); // Recursive call with element at index is in subset
		subsetList.remove(z);
	}
	static void generatePowerSet(int a[]){
		subsetList = new ArrayList<>();
		printPowerSet(a, 0);
	}
	
	/*
	 * Iterative solution
	 */
	
	static void powerSet(int a[]){
		int n = a.length;
		for(int i = 0; i < (1<<n); i++){
			for(int j = 0; j<n; j++){
				//System.out.println("i= " + i +" j = " + j);
				if(((1<<j)&i)!=0){
					System.out.print(a[j]+" ");
				}
			}
			System.out.println();
		}
	}	     
	
	public static int[][] subsets(int[] a) {
		int n = a.length;
		int N = (1<<n);
		int s[][] = new int [N][];
		Arrays.sort(a);
		ArrayList<String> list = new ArrayList<>();
		String str = null;
		for(int i = 0; i < N; i++){
			str = "";
			for(int j = 0; j<n; j++){
				if(((1<<j)&i)!=0){
					str = str+a[j]+"#";
				}
			}
			list.add(str);
		}
		list.sort((s1,s2)->{
			String ss1[] = s1.split("#");
			String ss2[] = s2.split("#");
			int n1 = ss1.length;
			int n2 = ss2.length;
			int i=0,j=0;
			int q1=0,q2=0;
			while(i<n1 && j<n2) {
				if(!ss1[i].isEmpty() && !ss2[j].isEmpty()) {
				q1 = Integer.parseInt(ss1[i]);
				q2 = Integer.parseInt(ss2[j]);
				if(q1<q2)return -1;
				else if(q2>q1)return 1;
				}
				i++;
				j++;
			}
			
			if(i<n1)return 1;
			else return -1;
		});
		int i=1,j=0;
		for(String z:list) {
			j = 0;
			if(!z.isEmpty()) {
				String[] zz = z.split("#");
				s[i]=new int[zz.length];
				for(String zzz: zz) {
					s[i][j++]=Integer.parseInt(zzz);
				}
				i++;
			}
		}
		s[0]=new int[0];
		return s;
    }
/*
	private static void printArray(String[] zz) {
		System.out.println("Here");
		for(String s:zz) {
			System.out.println(s);
		}
		System.out.println("End");
		
	}*/
	/*	i = 101
	j 1
	j 10
	j 100*/        
	public static void main(String[] args) {
		int a[]  = { 15, 20, 12, 19, 4 };
		//powerSet(a);  
		int ans[][] = subsets(a);
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[i].length;j++) {
				System.out.print(ans[i][j]+ " ");
			}
			System.out.println();
		}
		//System.out.println((1<<1));
		//System.out.println((1<<1)&2);
		

	}

}
