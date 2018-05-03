import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Tail {

	public static void main(String[] args) throws IOException, InterruptedException {
		String fileName = "test.txt";
		File f = new File(fileName);
		FileReader fr = new FileReader(f);

		BufferedReader br = new BufferedReader(fr);
		System.out.println(br.lines().count());
		FileReader fr1 = new FileReader(f);
		br= new BufferedReader(fr1);
		String s;
		int l = 1;
		while (true) {
			s = br.readLine();
			if (s == null)
				Thread.sleep(1000);
			else
				System.out.println(s);

		}

	}

}
