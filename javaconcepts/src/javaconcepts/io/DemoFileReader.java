package javaconcepts.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DemoFileReader {

	public static void main(String[] args) throws IOException {
		String inFile = "test.txt";
		File file = new File(inFile);
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        String line = null;
        while((line=br.readLine())!=null) {
        	System.out.println(line);
        }
        br.close();
        System.out.println("End of reader");
	}

}
