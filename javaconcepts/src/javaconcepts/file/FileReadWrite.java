package javaconcepts.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileReadWrite {

	public static List<String> readUsingStreams(String fileName) {
		List<String> fileContent = new ArrayList<>();
		try(Stream<String> fileLinesInStream = Files.lines(Paths.get(fileName))){
			   fileLinesInStream
			   .forEach(fileContent::add);
		 } catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
	
	public static void writeToFileUsingStreams(String content, String fileName) {
		try {
			Files.write(Paths.get(fileName), content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<String> readUsingBufferedReader(String fileName) {
		String line = "";
		List<String> data = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			while ((line = br.readLine()) != null) {
				data.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void writeUsingBufferedWriter(List<String> data, String fileName) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
			for(String line : data) {
				bw.write(line);
				bw.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		writeToFileUsingStreams("This is test content\nNew Line Started", "test");
		System.out.println(readUsingStreams("test"));
		
		writeUsingBufferedWriter(Arrays.asList("abc", "def"), "testFile");
		System.out.println(readUsingBufferedReader("testFile"));

	}

}
