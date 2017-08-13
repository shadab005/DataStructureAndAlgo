package fkart.smake;
import java.util.HashMap;
import java.util.List;

import fkart.datamodel.ParseData;
import fkart.parser.Parser;

public class SimpleMake {

	HashMap<String, List<String>> commandDependencyMap;
	HashMap<String, String> commandMap;
	HashMap<String, Integer> visited;
	
	public SimpleMake(String file) {
		visited = new HashMap<>();
		init(file);
	}
	private void init(String file){
		ParseData pd = null;
		try {
			pd = Parser.buildInput(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		commandDependencyMap = pd.getCommandDependencyMap();
		commandMap = pd.getCommandMap();
	}
	/*void printIputData(){
		System.out.println("Command dependency map");
		commandDependencyMap.forEach((k,v)->System.out.println("Item : " + k + " Depedency List : " + v));
		System.out.println("Command Map");
		commandMap.forEach((k,v)->System.out.println("Item : " + k + " Command : " + v));
	}*/
	
	private void smake(String command) throws Exception{
		if(visited.get(command)!= null && visited.get(command)==1)return;
		visited.put(command, 0); //0 means child is getting traversed
		List<String> dependencyList = commandDependencyMap.get(command);
		if(dependencyList!=null){
		for(String dependency : dependencyList){
			if(visited.get(dependency)==null){
				smake(dependency);
			}
			if(visited.get(dependency)==0){
				throw new Exception("Cyclic dependency");
			}
		}
		}
		String cmd = commandMap.get(command);
		if(cmd!=null){
				System.out.print(cmd);
		}
		visited.put(command, 1);
	}
	
	public void execute(String cmd){
		if(!cmd.contains("smake"))System.out.println("Invalid command");
		else{
			cmd = cmd.split("smake")[1].trim();
			try {
				if(commandDependencyMap.get(cmd)==null && commandMap.get(cmd)==null){
					throw new Exception("Invalid commad");
				}
				smake(cmd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		SimpleMake sm = new SimpleMake("makefile.txt");
		sm.execute("smake greet_and_move_on");
		/*Scanner in = new Scanner(System.in);
		System.out.println("Enter commnad :");
		String cmd = in.nextLine();
		if(!cmd.contains("smake"))System.out.println("Ivalid command");
		else{
			cmd = cmd.split("smake")[1].trim();
			sm.smake(cmd);
		}
		in.close();*/

	}
	
	
	
	

}

