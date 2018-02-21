package module.parkinglot;

public class ParkingManager {

	private CostCalculator costCalculator;
	
	private SlotManager slotManager;
	
	private TicketManager ticketManager;
	
	private PaymentService paymentService;
	
	public ParkingManager(CostCalculator cal, SlotManager mgr, TicketManager tmgr) {
		costCalculator = cal;
		slotManager = mgr;
		ticketManager = tmgr;
	}
	
	/**
	 * @param vehicle
	 * @return parking id 
	 */
	public ParkingTicket park(Vehicle vehicle) throws Exception{
		Slot slot = slotManager.getSlot(vehicle.getType());
		ParkingTicket ticket = ticketManager.generateParkingTicket(vehicle, slot);
		return ticket;
	}
	
	public void unpark(int ticketId) {
		try {
		ParkingTicket ticket = ticketManager.getTicket(ticketId);
		double amountPayable = costCalculator.getTotal(ticket);
		paymentService.collectMoney(amountPayable);//should be idempotent with retry logic
		slotManager.freeSlot(ticket.getSlot());
		ticketManager.releaseTicket(ticketId);
		}catch(Exception e) {
			
		}
	}
	
}
