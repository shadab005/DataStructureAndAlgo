package databricks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test {
	
	public static void main(String[] args) {
		writeToFile("Test content", "temp");
	}
	
	public static List<String> testFileReadUsingStreams() {
		List<String> fileContent = new ArrayList<>();
		try(Stream<String> fileLinesInStream = Files.lines(Paths.get("testFile"))){
			   fileLinesInStream
			   .forEach(fileContent::add);
		 } catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
	
	public static void writeToFile(String content, String fileName) {
		try {
			Files.write(Paths.get(fileName), content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	
}
