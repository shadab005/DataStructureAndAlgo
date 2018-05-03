package javaconcepts.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DemoFileWriter {

	public static void main(String[] args) throws IOException {
		 String outFile = "test.txt";
		 int count = 5;
		 int sum = 50;
		 File fout = new File(outFile);
         FileWriter fos = new FileWriter(fout);
         BufferedWriter bw = new BufferedWriter(fos);
         bw.write(count+"");
         bw.newLine();
         bw.write(sum+"");
         bw.close();
         System.out.println("End");

	}

}
