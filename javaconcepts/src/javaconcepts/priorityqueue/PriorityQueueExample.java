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
		
		public String toString() {
			return "[ "+ name +" , "  + roll +" ]";
		}
	};
	
	public static void main(String[] args) {
		Comparator<Student> byName = (o1,o2)->o1.name.compareTo(o2.name);
		Comparator<Student> byRoll = (x,y)->x.roll-y.roll; //For min heap
		
		/*
		 * Here we are passing comparator to our pq.
		 * We could also have defined Student class to be comparable
		 * and in that case I don't need to 
		 */

		PriorityQueue<Student> pq = new PriorityQueue<Student>(byRoll);
		pq.add(new Student("Shadab",5));
		pq.add(new Student("Sud",12));
		pq.add(new Student("Ayubi",8));
		/*for(Student ss:pq) {
			System.out.println(ss);
		}*/
		/*System.out.println(pq);
		System.out.println(pq.remove().name);
		System.out.println(pq.remove().name);
		System.out.println(pq.remove().name);*/
		
		/*for(Student s : pq){
			System.out.println(s.name);	
		}
		System.out.println(pq.remove().name);
		System.out.println(pq.remove().name);
		System.out.println(pq.remove().name);
		*/
		System.out.println(pq.remove().name);
		System.out.println(pq.remove().name);
		System.out.println(pq.remove().name);

	}
	
	static class StudentComparator implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			return o1.roll-o2.roll;
		}
		
	}

}
