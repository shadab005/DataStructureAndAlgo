package javaconcepts.singleton;

class Single {
	 public static Single getInstance()
	 {
		 System.out.println("value of enum static var : " + SingleObjectHolder.y);
		 System.out.println("value of enum non static var : " + SingleObjectHolder.INSTANCE1.x);
		 return SingleObjectHolder.INSTANCE1.obj;
	 }
	 
	  enum SingleObjectHolder
	 {
		 INSTANCE1
		 {
			 @Override
			 void f()
			 {
				 System.out.println("Instance1 method f");
			 }
		 };
		 Single obj = new Single();
		 
		 private int x = 10;
		 static int y = 20;
		 void f()
		 {
			 System.out.println("main method");
		 }
		 SingleObjectHolder() //by default private constructor
		 {
			 
		 }
	 }
	 
}

enum X
{
	}