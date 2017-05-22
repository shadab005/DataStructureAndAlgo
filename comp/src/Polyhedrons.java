import java.util.Scanner;

public class Polyhedrons {

	public static void main(String[] args) {
		long sum=0;
		Scanner sc = new Scanner(System.in);  
		int n      = sc.nextInt();
		String shape=null;
		for (int j = 0; j < n; j++) {
			shape=sc.next();
			switch(shape){
			case "Tetrahedron":
				sum=sum+4;
				break;
			case "Cube":
				sum=sum+6;
				break;
			case "Octahedron":
				sum=sum+8;
				break;
			case "Dodecahedron":
				sum=sum+12;
				break;
			case "Icosahedron":
				sum=sum+20;
				break;

			}
		}
		sc.close();
		System.out.print(sum);

	}

}
