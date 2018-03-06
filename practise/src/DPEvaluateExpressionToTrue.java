

/*
 *  Given expression with operands and operators (OR , AND , XOR) ,
 *  in how many ways can you evaluate the expression to true, by grouping in different ways? 
 *  Operands are only true and false.
 *  ex : string :  T|F&T^T
 *  https://www.interviewbit.com/problems/evaluate-expression-to-true/
 */
public class DPEvaluateExpressionToTrue {

	public int cnttrue(String s) {
		
		return 0;
    }
	
	//character at ith and jth position are operands
	public int cnttrue(String s, int i , int j) {
		if(j==i)return 1;
		if(j-i==2)return 1;
		int total = 0;
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		

	}

}
