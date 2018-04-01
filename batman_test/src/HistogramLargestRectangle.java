import java.util.Stack;

public class HistogramLargestRectangle {

	public static int getMaxArea(int h[]) {
		int area = 0;
		Stack<Integer> s = new Stack<>();
		int j = 0;
		int top = -1;
		for(int i=0;i<h.length;i++) {
			j = i;
			if(!s.isEmpty())top = s.peek();
			while(!s.isEmpty() && h[s.peek()]>h[i]) {
				j = s.pop();
			    area = Math.max(area, (top-j+1)*h[j]);
			}
			h[j]=h[i];
			s.push(j);
			if(i!=j)s.push(i);
		}
		if(!s.isEmpty())top = s.peek();
		while(!s.isEmpty()){
			j = s.pop();
			area = Math.max(area, (top-j+1)*h[j]);
		}
		
		return area;
	}
	
	public static int findLargestRectangle(int h[]) {
		int area = 0;
		Stack<Integer> hStack = new Stack<>();
		Stack<Integer> posStack = new Stack<>();
		int currentHeight = 0;
		int tempH = 0;
		int tempPos = 0;
		for(int i=0;i<h.length;i++) {
			currentHeight = h[i];
			tempPos = i;
			if(hStack.isEmpty() || currentHeight > hStack.peek()) {
				hStack.push(currentHeight);posStack.push(i);
			}else if(currentHeight < hStack.peek()){
				while(!hStack.isEmpty() && currentHeight < hStack.peek()) {
					tempH = hStack.pop();
					tempPos = posStack.pop();
					area = Math.max(area, (i-tempPos)*tempH);
				}
				hStack.push(currentHeight);
				posStack.push(tempPos);
			}
		}
		while(!hStack.isEmpty()) {
			tempH = hStack.pop();
			tempPos = posStack.pop();
			area = Math.max(area, (h.length-tempPos)*tempH);
		}
		return area;
	}
	public static void main(String[] args) {
		int hist[] = {6,2,5,4,5,1,6};
		System.out.println(getMaxArea(hist));
		System.out.println(findLargestRectangle(hist));
	}

}
