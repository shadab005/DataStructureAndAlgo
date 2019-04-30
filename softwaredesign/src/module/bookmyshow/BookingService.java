package module.bookmyshow;

import java.util.List;

public class BookingService {

	Ticket bookMovieShow(MovieShow movieShow, List<Seat> seats) {
		//Verify if the seats is still available
		//lock the seats
		//create booking ticket with status BOOKING_PROGRESS for the seats and return to the user
		//with the ticket user will invoke the payment service to make the payment successful
		return null;
	}
	
	Ticket markBookingSuccessful(Ticket ticket) {
		
		return null;
	}
}
