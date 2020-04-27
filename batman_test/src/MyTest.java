import java.util.function.Supplier;

public class MyTest {

	public static void main(String[] args) {
		
		//Supplier<? extends X> s = ()->new Y();
		//Supplier<Y> s2 = s; 
	}
}


class F{
	/*<T extends X> void fun(T x) {
		System.out.println("In fun A");
		x.f1();
	}*/
	
	void foo(Number s) {
		
	}
}

class K extends F{

	/*@Override
	<T extends X> void fun(<T extends X> x) {
		y.f2();
	}
	*/
	
	@Override
	void foo(Number s) {
		
	}
}

