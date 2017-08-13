package fkart.datamodel;
import java.util.HashMap;
import java.util.List;

public class ParseData {
	public HashMap<String, List<String>> commandDependencyMap;
	public HashMap<String, String> commandMap;
	
	public ParseData(HashMap<String, List<String>> commandDependencyMap, HashMap<String, String> commandMap) {
		this.commandDependencyMap = commandDependencyMap;
		this.commandMap = commandMap;
	}
	public HashMap<String, List<String>> getCommandDependencyMap(){
		return commandDependencyMap;
	}
	
	public HashMap<String, String> getCommandMap(){
		return commandMap;
	}

}
