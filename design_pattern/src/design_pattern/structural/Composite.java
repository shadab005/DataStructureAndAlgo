package design_pattern.structural;

import java.util.ArrayList;

/*
 * Composite is a structural design pattern that lets you compose objects 
 * into tree structures and then work with these structures as if they were individual objects.
 * 
 * Use the pattern when you want the client code to treat both simple and complex elements uniformly.
 * You can use Iterators to traverse Composite trees.
 * 
 * Structure
 * 
 * interface Component : +execute()
 * class LeafComponent implements Component
 * 
 * class CompositeComponent implements Component
 *   - has list/Array of Component
 *  +execute() -- delegate all work to child component
 */

interface AbstractFile {
	void ls();
}

class File implements AbstractFile {
	private String name;

	public File(String name) {
		this.name = name;
	}

	@Override
	public void ls() {
		System.out.println(name);
	}
}

class Directory implements AbstractFile {
	private String name;
	private ArrayList<AbstractFile> includedFiles = new ArrayList<>();

	public Directory(String name) {
		this.name = name;
	}

	public void add(AbstractFile abstractFile) {
		includedFiles.add(abstractFile);
	}

	@Override
	public void ls() {
		System.out.println(name + " :");
		for (AbstractFile abstractFile : includedFiles) {
			abstractFile.ls();
		}
	}

}

public class Composite {

	public static void main(String[] args) {
		Directory music = new Directory("MUSIC");
		Directory scorpions = new Directory("SCORPIONS");
		Directory dio = new Directory("DIO");
		File track1 = new File("Don't wary, be happy.mp3");
		File track2 = new File("track2.m3u");
		File track3 = new File("Wind of change.mp3");
		File track4 = new File("Big city night.mp3");
		File track5 = new File("Rainbow in the dark.mp3");
		music.add(track1);
		music.add(scorpions);
		music.add(track2);
		scorpions.add(track3);
		scorpions.add(track4);
		scorpions.add(dio);
		dio.add(track5);
		
		music.ls();

	}

}
