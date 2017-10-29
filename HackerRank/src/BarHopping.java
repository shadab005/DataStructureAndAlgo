import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * https://www.hackerearth.com/fr/practice/algorithms/graphs/graph-representation/practice-problems/algorithm/mancunian-and-liverbird-go-bar-hopping-2/
 * 
 */
public class BarHopping {

	static int a[];
	static int l[];
	static int r[];
	static int n;
	public static void main(String[] args) throws IOException {
		/*Scanner in = new Scanner(System.in);
		n = in.nextInt();*/
		
		Reader scan = new Reader();
	    PrintWriter out = new PrintWriter(System.out,true);
	    n = scan.nextInt();
		a = new int[n];
		r = new int[n];
		l = new int[n];
		for (int i = 1; i < n; i++) {
			a[i] = scan.nextInt();
		}

		int i = 1, j = 2;
		while (j < n) {
			if (a[i] != a[j]) {
				while (i < j) {
					r[i] = j - 1;
					i++;
				}
			}
			j++;
		}
		while (i < n) {
			r[i] = n-1;
			i++;
		}

		/*System.out.println("Printing right array");
		Util.printArray(r);*/

		i = n-1;
		j = i - 1;
		while (j >= 1) {
			if (a[i] != a[j]) {
				while (i > j) {
					l[i] = j+1;
					i--;
				}
			}
			j--;
		}
		while (i >= 1) {
			l[i] = 1;
			i--;
		}
		
		/*System.out.println("Printing Left array");
		Util.printArray(l);
*/
		int q = scan.nextInt();
		//System.out.println("Lollll " + q);
		int sign = 1;
		String command = null;
		//System.out.println("Going to solve now for q = " + q);
		//scan.readLine();
		scan.readLine();
		while (q-- > 0) {
			command = scan.readLine().trim();//in.nextLine();
			//System.out.println("Going to execute command " + command);
			if(command.equals("U")) {
				sign=sign^1;
			}else {
				int index = Integer.parseInt(command.split(" ")[1]);
				//System.out.println("Solving for index " + index);
				out.println(countNumberofBars(index, sign));
			}
		}

		//in.close();
	}
	
	static int countNumberofBars(int index, int sign) {
		int ans = 0;
		int leftroad=index-1;
		if(index>1) {
			if(sign!=a[leftroad]) {
				ans+=leftroad-l[leftroad]+1;
			}
		}
		
		int rightroad=index;
		if(index<n) {
			if(sign==a[rightroad]) {
				ans+=r[rightroad]-rightroad+1;
			}
		}
		return ans+1;//+1 because the node itself
	}
	
	 static class Reader {
		    final private int BUFFER_SIZE = 1 << 16;
		    private DataInputStream din;
		    private byte[] buffer;
		    private int bufferPointer, bytesRead;
		 
		    public Reader() {
		        din = new DataInputStream(System.in);
		        buffer = new byte[BUFFER_SIZE];
		        bufferPointer = bytesRead = 0;
		    }
		 
		    public Reader(String file_name) throws IOException {
		        din = new DataInputStream(new FileInputStream(file_name));
		        buffer = new byte[BUFFER_SIZE];
		        bufferPointer = bytesRead = 0;
		    }
		 
		    public String readLine() throws IOException {
		        byte[] buf = new byte[64];
		        int cnt = 0, c;
		        while ((c = read()) != -1) {
		            if (c == '\n') break;
		            buf[cnt++] = (byte) c;
		        }
		        return new String(buf, 0, cnt);
		    }
		 
		    public int nextInt() throws IOException {
		        int ret = 0;
		        byte c = read();
		        while (c <= ' ') c = read();
		        boolean neg = (c == '-');
		        if (neg) c = read();
		        do {
		            ret = ret * 10 + c - '0';
		        } while ((c = read()) >= '0' && c <= '9');
		        if (neg) return -ret;
		        return ret;
		    }
		 
		    public long nextLong() throws IOException {
		        long ret = 0;
		        byte c = read();
		        while (c <= ' ') c = read();
		        boolean neg = (c == '-');
		        if (neg) c = read();
		        do {
		            ret = ret * 10 + c - '0';
		        } while ((c = read()) >= '0' && c <= '9');
		        if (neg) return -ret;
		        return ret;
		    }
		 
		    public double nextDouble() throws IOException {
		        double ret = 0, div = 1;
		        byte c = read();
		        while (c <= ' ') c = read();
		        boolean neg = (c == '-');
		        if (neg) c = read();
		        do {
		            ret = ret * 10 + c - '0';
		        } while ((c = read()) >= '0' && c <= '9');
		        if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
		        if (neg) return -ret;
		        return ret;
		    }
		 
		    private void fillBuffer() throws IOException {
		        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		        if (bytesRead == -1) buffer[0] = -1;
		    }
		 
		    private byte read() throws IOException {
		        if (bufferPointer == bytesRead) fillBuffer();
		        return buffer[bufferPointer++];
		    }
		 
		    public void close() throws IOException {
		        if (din == null) return;
		        din.close();
		    }
		}
		  
	

}
