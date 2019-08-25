package design_pattern.creational;

/*
 * Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.
 * A factory of factories; a factory that groups the individual but related/dependent factories together without specifying their concrete classes.
 * When to use? 
 * When there are interrelated dependencies with not-that-simple creation logic involved
 */

class Button {}
class WinButton extends Button{}
class MacButton extends Button{}

class Checkbox {}
class WinCheckbox extends Checkbox{}
class MacCheckbox extends Checkbox{}


interface GuiFactory {
	Button createButton();
	Checkbox createCheckBox();
}

class MacFactory implements GuiFactory {
	@Override
	public Button createButton() {
		return new MacButton();
	}

	@Override
	public Checkbox createCheckBox() {
		return new MacCheckbox();
	}
}

class WinFactory implements GuiFactory {
	@Override
	public Button createButton() {
		return new WinButton();
	}

	@Override
	public Checkbox createCheckBox() {
		return new WinCheckbox();
	}
}


//Client code using the factory
class GUIApplication {
	GuiFactory guiFactory;
	public GUIApplication(GuiFactory factory) {
		this.guiFactory = factory;
	}
	
	public void paint() {
		Button b = guiFactory.createButton();
		Checkbox c = guiFactory.createCheckBox();
		//add it to ui
	}
}

public class AbstractFactory {

	public static void main(String[] args) {
		GUIApplication application = new GUIApplication(new MacFactory());
		application.paint();

	}

}
