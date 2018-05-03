package module.vendingmachine;

public enum Denomination {

	FIVE(5), TEN(10), FIFTY(50);	
	
	private int value;
	Denomination(int val){
		value = val;
	}
	
	int getValue() {
		return value;
		
	}
}
