package design_pattern.behavioral;

/*
 * It helps building a chain of objects. Request enters from one end and keeps going from object to object till it finds the suitable handler.
 * Use the Chain of Responsibility Pattern when you want to give more than one object a chance to handle a request.
 * With the Chain of Responsibility Pattern, you create a chain of objects that examine a request. 
 * Each object in turn examines the request and handles it, or passes it on to the next object in the chain.
 * 
 * structure:
 * interface Handler : +setSuccessor(Handler h), +handleRequest()
 * ConcreateHandler1 -> ConcreteHandler2 -> ...
 * 
 */

class Email {

	public String getFrom() {
		// TODO Auto-generated method stub
		return null;
	}
}

interface EmailHandler {
	public void setNext(EmailHandler handler);

	public void handleRequest(Email email);
}

class BusinessMailHandler implements EmailHandler {
	private EmailHandler next;

	public void setNext(EmailHandler handler) {
		next = handler;
	}

	public void handleRequest(Email email) {
		if (!email.getFrom().endsWith("@businessaddress.com")) {
			next.handleRequest(email);
		} else { // handle request (move to correct folder)}}}

		}
	}
}

class GmailHandler implements EmailHandler {
	private EmailHandler next;

	public void setNext(EmailHandler handler) {
		next = handler;
	}

	public void handleRequest(Email email) {
		if (!email.getFrom().endsWith("@gmail.com")) {
			next.handleRequest(email);
		} else { // handle request (move to correct folder)}}}

		}
	}
}

public class ChainOfResponsibility {

	public static void main(String[] args) {
		Email email = new Email();
		EmailHandler handler = new BusinessMailHandler();
		handler.setNext(new GmailHandler());
		handler.handleRequest(email);
	}

}
