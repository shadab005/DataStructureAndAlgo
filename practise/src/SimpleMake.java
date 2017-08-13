import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SimpleMake {

	HashMap<String, List<String>> commandDependencyMap;
	HashMap<String, String> commandMap;
	
	public SimpleMake() {
		commandDependencyMap = new HashMap<>();
		commandMap = new HashMap<>();
	}
	
	public void printMap(){
		
	}
	
	public static void main(String[] args) {
		SimpleMake sm = new SimpleMake();
		sm.buildInput("makefile.txt");
		sm.printMap();
        System.out.println("End of Program");

	}
	
	void buildInput(String FILE){
		BufferedReader br = null;
		try {

			String sCurrentLine;
			br = new BufferedReader(new FileReader(FILE));

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				if(!sCurrentLine.contains("\tprint") && sCurrentLine.contains(":")){
					String[] strs = sCurrentLine.split(":");
					//System.out.println(strs[0]);
					if(strs.length>1){
					//System.out.println(strs[1].trim());
					commandDependencyMap.put(strs[0], Arrays.asList(strs[1].trim().split(" ")));
					}
					if((sCurrentLine = br.readLine()) != null){
					   if(!sCurrentLine.isEmpty())
					   //System.out.println(sCurrentLine.split("\tprint")[1].replaceAll("\"", "").trim());
					   commandMap.put(strs[0], sCurrentLine.split("\tprint")[1].replaceAll("\"", "").trim());
					}
				}
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}	
	}

}
