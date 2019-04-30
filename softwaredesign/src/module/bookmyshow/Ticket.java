package module.bookmyshow;

import java.util.List;

public class Ticket {
	
	int ticketId;
	
	String movieName;
	
	int audiNumber;
	
	List<Seat> bookedSeats;
	
	String showTime;
	
	int totalAmount;

	String ticketStatus; //Can be BOOKING_CANCELLED, BOOKING_PROGRESS, BOOKING_COMPLETE, BOOKING_FAILED
	
}
