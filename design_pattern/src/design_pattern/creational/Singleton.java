package design_pattern.creational;

/*
 * Singleton is a creational design pattern that lets you ensure 
 * that a class has only one instance, while providing a global access point to this instance.
 */

//Follows lazy initialization
class Database {
	
	private static volatile Database database;
	private Database() {}
	
	public static Database getInstance() {
		if(database == null) {
			synchronized (Database.class) {
				if(database == null) {
					database = new Database();
				}
			}
		}
		return database;
	}
}
public class Singleton {

	public static void main(String[] args) {
		Database db1 = Database.getInstance();
		Database db2 = Database.getInstance();
		System.out.println(db1==db2);

	}

}
