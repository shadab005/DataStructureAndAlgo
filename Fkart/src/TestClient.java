import fkart.smake.SimpleMake;

public class TestClient {

	public static void main(String[] args) {
		SimpleMake sm = new SimpleMake("makefile.txt");
		sm.execute("smake say_bye");

	}

}
