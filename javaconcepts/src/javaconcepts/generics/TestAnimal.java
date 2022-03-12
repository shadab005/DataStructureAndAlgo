package javaconcepts.generics;

import java.util.ArrayList;
import java.util.List;

public class TestAnimal {

	public static void main(String[] args) {
		ArrayList<Dog> d = new ArrayList<>();

		d.add(new Dog());
		TestAnimal t = new TestAnimal();
		t.addAnimal(d);
		t.addDog(d);
		t.fun(d);
		ArrayList<Animal> a = new ArrayList<>();
		t.fun(a);
	}

	public void addAnimal(List<? extends Animal> animals) {
		System.out.println("Just for fun");
		System.out.println("Number of animals is " + animals.size());
		// animals.add(new Dog()); Compilation fail
	}

	public void addDog(List<? extends Dog> dogs) {
		System.out.println("Just for another fun");
		System.out.println("Number of dogs is " + dogs.size());
		// dogs.add(new Dog()); Compilation fail
	}

	public void fun(List<? super DogDog> dogs) {
		System.out.println("Just for another fun");
		System.out.println("Number of dogs is " + dogs.size());
		//dogs.add(new Dog());
		dogs.add(new DogDog());
		dogs.add(new DogDogDog());
		// dogs.add(new Dog()); Compilation fail
	}

}
