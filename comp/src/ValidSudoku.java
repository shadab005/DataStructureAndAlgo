import java.util.Arrays;

public class ValidSudoku {

	//ASCI char(0-9) => (48-57)
	public int isValidSudoku(final String[] a) {
     
		int s[][] = new int[9][9];
		int i = 0;
		int j = 0;
		for(String z:a) {
			j = 0;
			for(char c:z.toCharArray()) {
				if(c!='.') {
					s[i][j]=c-48;
				}
				j++;
			}
			i++;
		}
		if(!isValidRowWise(s))return 0;
		if(!isValidColWise(s))return 0;
		if(!isValidGridWise(s))return 0;
		return 1;
	}

	private boolean isValidGridWise(int[][] s) {
		for(int i=0;i<9;i=i+3) {
			for(int j=0;j<9;j=j+3) {
				if(!validSmallGrid(s,i,j))return false;
			}
		}
	
		return true;
	}

	private boolean validSmallGrid(int[][] s, int i, int j) {
		int map[] = new int[10];
		for(int x=i;x<i+3;x++) {
			for(int y=j;y<j+3;y++) {
				if(s[x][y]!=0) {
					if(map[s[x][y]]!=0)return false;
					map[s[x][y]]=1;
				}
			}
		}
		return true;
	}

	private boolean isValidColWise(int[][] s) {
		int map[] = new int[10];
		for(int i=0;i<9;i++) {
			Arrays.fill(map, 0);
			for(int j = 0 ; j<9 ; j++) {
				if(s[j][i]!=0) {
					if(map[s[j][i]]!=0)return false;
					map[s[j][i]]=1;
				}
			}
		}
		return true;
	}

	private boolean isValidRowWise(int[][] s) {
		int map[] = new int[10];
		for(int i=0;i<9;i++) {
			Arrays.fill(map, 0);
			for(int j = 0 ; j<9 ; j++) {
				if(s[i][j]!=0) {
					if(map[s[i][j]]!=0)return false;
					map[s[i][j]]=1;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		String s[] = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
		for(String z:s) {
			System.out.println(z);
		}
		
		ValidSudoku validaor = new ValidSudoku();
		System.out.println(validaor.isValidSudoku(s));
		

	}

}
