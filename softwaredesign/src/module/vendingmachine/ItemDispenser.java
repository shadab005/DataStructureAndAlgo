package module.vendingmachine;

public class ItemDispenser {

	Inventory inventory;
	
	public void dispense(int itemCode) throws ItemNotAvailable {
		Item item = inventory.getItem(itemCode);
		
	}

}
