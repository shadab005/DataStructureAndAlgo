package swiggy.models;

public class Assignment{
	private Order order;
	private DeliveryExecutive deliveryExecutive;
	public Assignment(Order order, DeliveryExecutive d) {
		this.order=order;
		this.deliveryExecutive=d;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public DeliveryExecutive getDeliveryExecutive() {
		return deliveryExecutive;
	}

	public void setDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
		this.deliveryExecutive = deliveryExecutive;
	}

	@Override
	public String toString() {
		return "{\"order_id\":"+ order.getId()+",\"de_id\":"+deliveryExecutive.getId()+"}";
	}
}