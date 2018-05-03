package module.vendingmachine;

public class VendingMachine {
	
	MoneySlot moneySlot;
	
	private ItemRequestService itemService;
	
	public void processRequest(int itemCode) {
		if(moneySlot.hasMoney()){
			itemService.dispenseItem(itemCode);
		}else {
			itemService.displayPrice(itemCode);
		}
	}

}


