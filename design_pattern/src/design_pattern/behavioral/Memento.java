package design_pattern.behavioral;

/*
 * Memento is a behavioral design pattern that lets you save and restore the previous state of an object
 * without revealing the details of its implementation.
 * The pattern suggests storing the copy of the object’s state in a special object called memento.
 * The contents of the memento aren’t accessible to any other object except the one that produced it.
 * 
 * The Memento pattern lets you make full copies of an object’s state, including private fields, 
 * and store them separately from the object. While most people remember this pattern thanks to the “undo” 
 * use case, it’s also indispensable when dealing with transactions
 * 
 * The client requests a Memento from the source object when it needs to checkpoint the source object's state. 
 * The source object initializes the Memento with a characterization of its state. 
 * The client is the "care-taker" of the Memento, but only the source object can store 
 * and retrieve information from the Memento (the Memento is "opaque" to the client and all other objects).
 * If the client subsequently needs to "rollback" the source object's state, it hands the Memento back to the source object for reinstatement.
 * 
 *  The Memento design pattern defines three distinct roles:
 *  1. Originator - the object that knows how to save itself.
 *  2. Caretaker - the object that knows why and when the Originator needs to save and restore itself.
 *  3. Memento - the lock box that is written and read by the Originator, and shepherded by the Caretaker.
 *  
 *  structure:
 *  class Momento +getState, setState(state) - has State
 *  class Originator +setMomento, +createMomento(){new Momento(state)} - has State
 */

class GameState{}
class GameMemento{
	GameState state;
	GameMemento(GameState state){
		this.state = state;
	}
}
class MasterGameObject{
	GameState state;
	//Returning Object isn’t a terribly fancy implementation, notice that the Client has no access to the Memento’s data.
	Object createMomento() {
		return new GameMemento(state);
	}
	public void restore(Object memento) {
		state = ((GameMemento)memento).state;
	}
	
}
public class Memento {

	public static void main(String[] args) {
		MasterGameObject masterGameObject = new MasterGameObject();
		Object savedState = masterGameObject.createMomento();
		//do something
		//now restore to the savedState
		masterGameObject.restore(savedState);

	}

}
