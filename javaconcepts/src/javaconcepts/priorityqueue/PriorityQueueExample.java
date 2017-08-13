package javaconcepts.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
	
	static class Student{
		String name;
		int roll;
		public Student(String name, int roll) {
			this.name=name;
			this.roll=roll;
		}
	};
	
	public static void main(String[] args) {
		Comparator<Student> byName = (o1,o2)->o1.name.compareTo(o2.name);
		Comparator<Student> byRoll = (o1,o2)->o2.roll-o1.roll; //For max heap
		
		/*
		 * Here we are passing comparator to our pq.
		 * We could also have defined Student class to be comparable
		 * and in that case I don't need to 
		 */

		PriorityQueue<Student> pq = new PriorityQueue<>(byRoll);
		
		pq.add(new Student("Shadab",5));
		pq.add(new Student("Sud",2));
		pq.add(new Student("ayubi",7));
		
		for(Student s : pq){
			System.out.println(s.name);	
		}
		System.out.println(pq.remove().name);
		System.out.println(pq.remove().name);
		System.out.println(pq.remove().name);
		

	}

}
