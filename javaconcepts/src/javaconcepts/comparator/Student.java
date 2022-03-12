package javaconcepts.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {

	private String name;
	private int section=0;
	//private static final Comparator<Student> BY_NAME = new ByName();
	private static final Comparator<Student> BY_SECTION = new BySection();

	public Student(String name, int section) {
		this.name=name;
		this.section=section;
	}

	public static void main(String args[]){
		List<Student> list = new ArrayList<>();
		list.add(new Student("shadab", 7));
		list.add(new Student("ankit", 9));
		Collections.sort(list,new BySection());
		for(Student s: list){
			System.out.println("Name = " + s.name + " Section =  " + s.section);
		}
	}

		/*private static class ByName implements Comparator<Student>
		{

			@Override
			public int compare(Student o1, Student o2) {
				return o1.name.compareTo(o2.name);
			}
		}*/

		private static class BySection implements Comparator<Student>
		{

			@Override
			public int compare(Student o1, Student o2) {
				return o1.section-o2.section;
			}

		}

}
