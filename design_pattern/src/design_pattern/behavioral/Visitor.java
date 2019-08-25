package design_pattern.behavioral;

/*
 * Visitor pattern lets you add further operations to objects without having to modify them.
 * It is a way of separating an algorithm from an object structure on which it operates.
 * Visitor pattern is not good for situtations where these visited classes are subject to change. 
 * Every time a new type of Element is added, every Visitor derived class must be amended. 
 * 
 * structure:
 * intereface Visitor : +visitElement(ConcreteElementOne element) +visitElement(ConcreteElementTwo element)
 * class ConcreteVisitor implements Visitor
 * 
 * interface Element : +accept(Visitor visitor) //other methods
 * class ConcreteElementOne implements Element{ +accept(Visitor visitor) {visitor.accept(this)}}	
 */

/*
 * Let's take an example of a zoo simulation where we have several different kinds of animals and we have to make them Sound. 
 * Let's translate this using visitor pattern
 */
//Visitee
interface Animal
{
    public void accept(AnimalOperation operation);
}
//Visitor
interface AnimalOperation
{
 public void visitMonkey(Monkey monkey);
 public void visitLion(Lion lion);
}
class Monkey implements Animal
{
    public void shout(){System.out.println("Ooh oo aa aa!");}
    public void accept(AnimalOperation operation){operation.visitMonkey(this);}
}
class Lion implements Animal
{
    public void roar(){System.out.println("Roaar!");}
    public void accept(AnimalOperation operation){operation.visitLion(this);}
}

//Concrete visitor
class Speak implements AnimalOperation
{
    public void visitMonkey(Monkey monkey){monkey.shout();}
    public void visitLion(Lion lion){lion.roar();}
}

/*
 * We could have done this simply by having an inheritance hierarchy for the animals
 * but then we would have to modify the animals whenever we would have to add new actions to animals.
 * But now we will not have to change them. For example, let's say we are asked to 
 * add the jump behavior to the animals, we can simply add that by creating a new visitor i.e
 */

class Jump implements AnimalOperation
{
    public void visitMonkey(Monkey monkey){System.out.println("Jumped 20 feet high! on to the tree!");}
    public void visitLion(Lion lion){System.out.println("Jumped 7 feet! Back on the ground!");}
}


public class Visitor {

	public static void main(String[] args) {
		Animal monkey = new Monkey();
		Animal lion = new Lion();
		AnimalOperation speak = new Speak();
		monkey.accept(speak);    // Ooh oo aa aa!    
		lion.accept(speak);      // Roaaar!
		
		AnimalOperation jump = new Jump();
		monkey.accept(jump);    // Jumped 20 feet high! on to the tree!
		lion.accept(jump);      // Jumped 7 feet! Back on the ground!
		
	}

}
