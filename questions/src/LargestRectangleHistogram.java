import java.util.Stack;

public class LargestRectangleHistogram {

	private static void findLargestRectangularArea(int[] height) {
		int n = height.length;
		Stack<Integer> s = new Stack<>();
		int maxArea=height[0];
		int top = -1;
		int j = 0;
		for(int i = 0; i < n ; i++){
			j = i;
			if(!s.isEmpty())top = s.peek();
			while(!s.isEmpty() && height[s.peek()] > height[i]){
				j = s.pop();
				maxArea = Math.max(maxArea, height[j]*(top-j+1));
			}
			height[j]=height[i];
			s.push(j);
			if(i!=j)s.push(i);
			
			//System.out.println(s + " " + maxArea);
			//Util.printArray(height);
		}
		if(!s.isEmpty())top = s.peek();
		while(!s.isEmpty()){
			j = s.pop();
			maxArea = Math.max(maxArea, height[j]*(top-j+1));
		}
		System.out.println(maxArea);
		
	}
	
	public static void main(String[] args) {
		int height[]={4 ,1000, 1000, 1000, 1000};
		int height2[] = {1,1,1,1,1,1,1,1,4,5,6,2,2};
		int hist[] = {7, 2, 1, 4, 5, 1, 3, 3};
		findLargestRectangularArea(height);
		findLargestRectangularArea(height2);
		findLargestRectangularArea(hist);
		/*Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int a[] ;
		for(int i = 1; i <= t; i++){
			int n = in.nextInt();
			a = new int[n];
			for(int j = 0; j < n ; j++){
				a[j]=in.nextInt();
			}
			findLargestRectangularArea(a);
		}
		in.close();*/
		
	}

}
