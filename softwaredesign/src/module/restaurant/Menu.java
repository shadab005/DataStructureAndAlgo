package module.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	private List<Item> items;
	
	public Menu() {
		items = new ArrayList<>();
	}
	
	public Menu(List<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void displayItems() {
		
	}

}
