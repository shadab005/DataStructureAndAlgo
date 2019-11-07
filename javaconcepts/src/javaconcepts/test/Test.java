package javaconcepts.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Test {

	public static void main(String[] args) {
		
		try(BufferedReader br = new BufferedReader(new FileReader("stream_example"))){
			System.out.println(br.readLine());
			fun();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(RuntimeException e) {
			//System.out.println(e);
		}
		finally {
			System.out.println("I am done");
		}
	}
	
	static void fun() {
		throw new RuntimeException("Dummy!");
	}

}
