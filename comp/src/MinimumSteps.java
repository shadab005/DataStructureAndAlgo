import java.util.ArrayList;

public class MinimumSteps {
	
	private static int minStep(int x1, int y1, int x2, int y2){
		
		/*int a=Math.min(Math.abs(x1-x2),Math.abs(y1-y2));
		int b=Math.max(Math.abs(x1-x2),Math.abs(y1-y2));
		return a+Math.abs(b-a);*/
		return Math.max( Math.abs(x1 - x2), Math.abs(y1 - y2) );
	}
	
	public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
		int countMinStep=0;
		for(int i = 0 ; i < X.size()-1 ; i++){
			countMinStep+=minStep(X.get(i), Y.get(i), X.get(i+1), Y.get(i+1));
		}
		return countMinStep;
    }

	public static void main(String[] args) {
		System.out.println(minStep(1, 2, 2, 6));
		System.out.println(minStep(1, 2, 1, 6));
		System.out.println(minStep(0, 0, 5, 5));
	}

}
