import java.util.HashMap;

public class ModifyPrice {

	public static void main(String[] args) {
		String[] origItems = {"rice","sugar","wheet","cheese"};
		float[] origPrices = {16.89f,56.92f,20.89f,345.99f};
		
		 String[] items = {"rice", "cheese"};
		 float[] prices = {18.99f, 345.99f};
		 
		 System.out.println(verifyItems(origItems, origPrices, items, prices));

	}
	
	  static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices) {
		  HashMap<String, Float> itemPriceMap = new HashMap<>();
		  
		  for(int i=0;i<origItems.length;i++) {
			  itemPriceMap.put(origItems[i], origPrices[i]);
		  }
		  int count = 0;
		  for(int i=0;i<items.length;i++) {
			  if(itemPriceMap.get(items[i])!=prices[i])count++;
		  }
		  return count;
	  }

}
