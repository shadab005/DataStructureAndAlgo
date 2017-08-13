import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreePallindrome {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new java.io.BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n == 1)
			System.out.println("a");
		else if (n == 2)
			System.out.println("aa");
		else {
			StringBuilder s = new StringBuilder("aab");
			for (int i = 3; i < n; i++) {
				// System.out.println("i="+i);
				if (s.charAt(i - 2) == 'a' && s.charAt(i - 1) == 'a') {
					s.append("b");
				} else if (s.charAt(i - 2) == 'b' && s.charAt(i - 1) == 'b') {
					s.append("a");
				} else if (s.charAt(i - 2) == 'a' && s.charAt(i - 1) == 'b') {
					s.append("b");
				} else if (s.charAt(i - 2) == 'b' && s.charAt(i - 1) == 'a') {
					s.append("a");
				}
			}
			System.out.println(s);
		}

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

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

}
