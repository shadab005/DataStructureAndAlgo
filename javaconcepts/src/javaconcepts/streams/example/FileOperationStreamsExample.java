package javaconcepts.streams.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// ref: https://www.youtube.com/watch?v=TCJdc9SYwlQ

public class FileOperationStreamsExample {

	public static void main(String[] args) throws IOException {
	   System.out.println("Start");
	   //Q.1 read file line by line. Append each line by #. And sort the file in alphabetical order. convert to upper case and print line by line.
	   //Note : we are using try-with-resource here
	   try(Stream<String> fileLinesInStream = Files.lines(Paths.get("stream_example"))){
		   fileLinesInStream
		   .map(s -> s+" # ")
		   .sorted()
		   .map(s->s.toUpperCase())
		   .forEach(System.out::println);
	   }

	   //Q.2 Find the length of the longest line
	   // # Optional
	   try(Stream<String> fileLinesInStream = Files.lines(Paths.get("stream_example"))){
		   fileLinesInStream
		   .mapToInt(String::length)
		   .max()
		   .ifPresent(System.out::println);
	   }

	   //Q.3 Find the longest line i.e print
	   try(Stream<String> fileLinesInStream = Files.lines(Paths.get("stream_example"))){
		   fileLinesInStream
		   .sorted((s1,s2) -> s2.length()-s1.length())
		   .findFirst()
		   .ifPresent(System.out::println);
	   }
	   //But the above solution is inefficient since normal imperative way of this will result in O(n) complexity. XXX
	   try(Stream<String> fileLinesInStream = Files.lines(Paths.get("stream_example"))){
		   fileLinesInStream
		   .reduce((x,y)-> x.length() > y.length() ? x : y)
		   .ifPresent(System.out::println);
	   }

	   //Simplest solution
	   try(Stream<String> fileLinesInStream = Files.lines(Paths.get("stream_example"))){
		   fileLinesInStream
		   .max((x,y)->x.length()-y.length())
		   .ifPresent(System.out::println);
	   }


	   System.out.println("End");


	}

}
