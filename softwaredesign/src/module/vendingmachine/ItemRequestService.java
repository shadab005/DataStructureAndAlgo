package module.vendingmachine;

public class ItemRequestService {

	RequestValidator requestValidator;
	MoneySlot moneySlot;
	ItemPriceService itemPriceService;
	ItemDispenser itemDispenser;
	ScreenDisplay screenDisplay;

	public void dispenseItem(int itemCode) {
		try {
			requestValidator.validate(itemCode);
			moneySlot.deductMoney(itemPriceService.getPrice(itemCode));
			itemDispenser.dispense(itemCode);
		} catch (InSufficientBalanceException | InvalidItemCode | ItemNotAvailable exception) {

		}finally {
			moneySlot.dispenseBalance();
		}
	}

	public void displayPrice(int itemCode) {
		screenDisplay.display(itemPriceService.getPrice(itemCode) + "");
	}	

}
