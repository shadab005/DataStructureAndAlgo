package fkart.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import fkart.datamodel.ParseData;

public class Parser {

	public static ParseData buildInput(String FILE) throws Exception {
		HashMap<String, List<String>> commandDependencyMap = new HashMap<>();
		HashMap<String, String> commandMap = new HashMap<>();

		BufferedReader br = null;
		try {

			String sCurrentLine;
			br = new BufferedReader(new FileReader(FILE));

			while ((sCurrentLine = br.readLine()) != null) {
				// System.out.println(sCurrentLine);
				if (!sCurrentLine.contains("\tprint") && sCurrentLine.contains(":")) {
					String[] strs = sCurrentLine.split(":");
					// System.out.println(strs[0]);
					if (strs.length > 1) {
						// System.out.println(strs[1].trim());
						commandDependencyMap.put(strs[0], Arrays.asList(strs[1].trim().split(" ")));
					}
					if ((sCurrentLine = br.readLine()) != null) {
						String cmd = "";
						if (!sCurrentLine.isEmpty()) {
							if(!sCurrentLine.contains("print")) throw new Exception("Invalid command");
							cmd = sCurrentLine.split("\tprint")[1].replaceAll("\"", "");
							cmd = cmd.replaceAll("^\\s+", "");
							commandMap.put(strs[0], cmd);
						}
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
		return new ParseData(commandDependencyMap, commandMap);
	}
}
