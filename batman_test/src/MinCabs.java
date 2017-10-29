import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinCabs {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String incoming[] = new String[n];
		String outgoing[] = new String[n];

		int t = n;
		String s = null;
		int i = 0;
		while (t-- > 0) {
			s = br.readLine();
			incoming[i] = s.split(" ")[0];
			outgoing[i] = s.split(" ")[1];
			i++;
		}

		Arrays.sort(incoming);
		Arrays.sort(outgoing);

		i = 0;
		int j = 1;
		int count = 0;
		int max = 0;

		while (i < n && j < n) {
			if (incoming[i].compareTo(outgoing[j])<=0)
		      {
				count++;
		         i++;
		          if (count > max) 
		        	  max = count;
		      }
		      else
		      {
		          count--;
		          j++;
		      }
		}
		System.out.println(max);

	}

}
