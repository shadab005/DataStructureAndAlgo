package design_pattern.behavioral;

import java.util.Stack;

/*
 * Allows you to encapsulate actions in objects. The key idea behind this pattern is to provide the means to decouple client from receiver.
 * Command pattern can also be used to implement a transaction based system.
 * Where you keep maintaining the history of commands as soon as you execute them.
 * 
 * structure:
 * Interface Command : +execute(), +undo()
 * ConcreteCommandOne implements Command
 * ConcreteCommandTwo implements Command
 * 
 * ConcreteCommand* has Receiver which is actually executed when Command is invoked
 * 
 * Invoker holds the CommandObject and calls its execute method to perform action
 * class Invoker : +setCommand
 * 
 * examples:
 * We can implement Remote like Object where each buttonn press execute some action like LightAction(on,off), FanAction(on,off)
 * Other example is we can We can implement AccountService where we can execute withdraw, deposit action
 * 
 */

class Account{
	int balance;
	public Account(int bal) {
		this.balance = bal;
	}
	public void deposit(int amount) {}
	public void withDraw(int amount) {}
}

//Command
interface Action{
	public void execute();
	public void undo();
}

//Concrete command
class WithdrawAction implements Action{
	Account account;
	int amount;
	WithdrawAction(Account account, int amount){
		this.account = account;
		this.amount = amount;
	}
	public void execute() {
		account.withDraw(amount);
	}
	public void undo() {
		account.deposit(amount);
	}
}
//Concrete command
class DepositAction implements Action{
	Account account;
	int amount;
	DepositAction(Account account, int amount){
		this.account = account;
		this.amount = amount;
	}
	public void execute() {
		account.deposit(amount);
	}
	public void undo() {
		account.withDraw(amount);
	}
}

//Invoker
class AccountService {
	Stack<Action> actions;
	Account account;
	AccountService(Account account){
		this.account = account;
		actions = new Stack<>();
	}
	
	public void withdraw(int amount) {
		Action action = new WithdrawAction(account, amount);
		action.execute();
		actions.add(action);
	}
    public void deposit(int amount) {
    	Action action = new DepositAction(account, amount);
    	action.execute();
		actions.add(action);
	}
    
    public void undo() {
    	if(!actions.isEmpty()) {
    		actions.pop().undo();
    	}
    }
	
}
public class Command {

	public static void main(String[] args) {
		Account account = new Account(100);
		AccountService accountService = new AccountService(account);
		accountService.deposit(200);
		accountService.withdraw(100);
		accountService.undo();

	}

}
