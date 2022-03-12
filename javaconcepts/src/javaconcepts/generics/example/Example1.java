package javaconcepts.generics.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

//Let’s say you want to map a type stored in a List to some other type.
//https://blog.kevinlee.io/2012/12/06/java-generics-generics-in-real-life-programming/
public class Example1 {

	//First way to write converter for every type
	public List<BigDecimal> takePricesOf(List<Product> list)
	{
	  List<BigDecimal> newList = new ArrayList<>();
	  for (Product product : list)
	  {
	    newList.add(product.getPrice());
	  }
	  return newList;
	}

	public List<DiscountedProduct> toDiscountedProducts(int discountRate, List<Product> list)
	{
	  List<DiscountedProduct> newList = new ArrayList<>();
	  for (Product product : list)
	  {
	    newList.add(new DiscountedProduct(product, discountRate));
	  }
	  return newList;
	}

	//Second way

	/*
	 Usage:
	 List<Object> productPriceList = mapWithoutGenerics(new Mapper() {
     public Object map(Object input)
     {
      Product product = (Product) input;
      return product.getPrice();
     }
     }, productList);


	 */

	public List<Object> mapWithoutGenerics(Mapper mapperWithoutGenerics, List<?> list)
	// <- this cannot be List<Object> since you want to pass a List of any type not just List<Object>.
	{
	  List<Object> newList = new ArrayList<>();
	  for (Object object : list)
	  {
	    newList.add(mapperWithoutGenerics.map(object));
	  }
	  return newList;
	}

	//Third way
	public <T, R, F extends Function<T, R>> List<R> map(F mapper, List<T> list)
	{
	  final List<R> newList = new ArrayList<>();
	  for (final T t : list)
	  {
	    newList.add(mapper.apply(t));
	  }
	  return newList;
	}

	public void thirdWayUsage() {
		Function<Product, BigDecimal> mapper = p -> p.getPrice();
		List<Product> productList = new ArrayList<>();
		List<BigDecimal> convertedList = map(mapper, productList);
		System.out.println(convertedList);
	}


	public interface Mapper
	{
	  Object map(Object input);
	}
}


 class DiscountedProduct{

	public DiscountedProduct(Product product, int discountRate) {
		// TODO Auto-generated constructor stub
	}

}

 class Product {

	public String getName() {
		return "";
	}
	public BigDecimal getPrice() {
		return null;
	}
}
