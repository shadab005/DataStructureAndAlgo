package javaconcepts.generics;

import java.util.ArrayList;
import java.util.List;

public class Dog extends Animal {

	@Override
	public void fun() {
		// TODO Auto-generated method stub
		
	}
	
	public List<Integer> dogFun(){
		return null;
	}

}


class DogDog extends Dog{
	
	@Override
	public ArrayList<Integer> dogFun(){
	
		System.out.println("Overridding this");
		return null;
	}
}

class DogDogDog extends DogDog{
	
	@Override
	public ArrayList<Integer> dogFun(){
	
		System.out.println("Overridding this");
		return null;
	}
}