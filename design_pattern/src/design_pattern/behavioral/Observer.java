package design_pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

/*
 * Defines a dependency between objects so that whenever an object changes its state, all its dependents are notified.
 * 
 * The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state,
 * all of its dependents are notified and updated automatically.
 * 
 */

//Also called Subject or Observable
interface Publisher {
	void subscribe(Subscriber subscriber);
	void unsubscribe(Subscriber subscriber);
	void notifySubscribers();
}

class WeatherData implements Publisher {

	private float temperature, humidity;
	List<Subscriber> subscribers = new ArrayList<>();

	public void subscribe(Subscriber subscriber) {
		subscribers.add(subscriber);

	}
	public void unsubscribe(Subscriber subscriber) {
		subscribers.removeIf(x -> x.equals(subscriber));
	}
	public void notifySubscribers() {
		subscribers.forEach(sub -> sub.update(temperature, humidity));
	}
	public void setWeather(float temp, float humidity) {
		temperature = temp;
		this.humidity = humidity;
		notifySubscribers();
	}

}

//Also called Observer, Listener
interface Subscriber {
	void update(float temperature, float humidity);
}

class CurrentConditionsDisplay implements Subscriber {
	private float temperature, humidity;
	@Override
	public void update(float temperature, float humidity) {
		this.temperature = temperature; this.humidity = humidity;
	}
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}
}

public class Observer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
