package module.inventorymanagement;

import java.util.Date;

//Received product
public class PurchaseInfo {

	String purchaseId;
	
	String productId;
	
	int quantity;
	
	double price;
	
	Date date;
	
	String supplierId;
	
}


class Supplier {
	String supplierId;
	String location;
}
