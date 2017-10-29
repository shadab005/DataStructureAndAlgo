package module.restaurant;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Restaurant {

	private String name; //restaurant name
	private List<Table> tables; //list of tables
	private Queue<Customer> customers;
	
	public Restaurant() {
		customers  = new LinkedList<>();
	}

	public void addTable(Table newTable) {
			tables.add(newTable);
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Table> getTables() {
		return tables;
	}
	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	
}
