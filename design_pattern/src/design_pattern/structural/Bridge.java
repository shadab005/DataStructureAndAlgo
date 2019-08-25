package design_pattern.structural;

/*
 * Bridge pattern is about preferring composition over inheritance. 
 * Implementation details are pushed from a hierarchy to another object with a separate hierarchy.
 * 
 * ex: we have different Shape class of different colors.
 * One way is to use inheritance and create classes
 * ex:
 * interface Shape
 * class Square implments Shape
 * class Rectangle implements Shape
 * 
 * Now, suppose we have to incorporate colors to hierarchy
 * we will have
 * class RedSquare implements Square
 * class BlueSquare implements Square
 * 
 * class RedRectangle implements Rectangle
 * class BlueRectangle implememts Rectangle
 * 
 * As  number of color or shape increases, the number of class will grow a lot in number.
 * 
 * 
 * Better way is to use composition
 * 
 * class Shape
 *  -has Color
 *  
 * class Square extends Shape
 * class Rectangle extends Shape
 * 
 * class Red extends Color
 * class Blue extends Color
 *   
 */
public class Bridge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
