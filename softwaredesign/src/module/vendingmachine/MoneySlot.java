package module.vendingmachine;

import java.util.List;

public class MoneySlot {

	private DenominationManager denominationManager;
	MoneyDispenser moneyDispenser;
	private int total;
	
	public boolean hasMoney() {
		return false;
	}
	
	public void insertDenomitnation(Denomination denomination) {
		
	}
	
	public int getMoney() {
		return 0;
	}

	public void deductMoney(int itemPrice) {
		total=total-itemPrice;
	}
	
	public void dispenseBalance() {
		List<Denomination> denominationsToDispense = denominationManager.getDenominatorForAmount(total);
	    moneyDispenser.dispense(denominationsToDispense);
	}

}
