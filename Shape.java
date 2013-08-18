abstract class Shape {

	protected int a, b, c;
	abstract int area();

	public static void main(String[] args) {

		Trapezoid trapezoid = new Trapezoid();
		Parallelogram parallelogram = new Parallelogram();
		Rectangle rectangle = new Rectangle();
		Square square = new Square();
		Polygon polygon = new Polygon();
		Pentagon pentagon = new Pentagon();
		Hexagon hexagon = new Hexagon();
		Heptagon heptagon = new Heptagon();

		System.out.println("The area of a Trapezoid is " + trapezoid.area());
		System.out.println("The area of a Parallelogram is " + parallelogram.area());
		System.out.println("The area of a Rectangle is " + rectangle.area());
		System.out.println("The area of a Square is " + square.area());
		System.out.println("The area of a Polygon is " + polygon.area());
		System.out.println("The area of a Pentagon is " + pentagon.area());
		System.out.println("The area of a Hexagon is " + hexagon.area());
		System.out.println("The area of a Heptagon is " + heptagon.area());
	}
}

class Trapezoid extends Shape {
	public Trapezoid() {
		a = b = c = 2;
	}

	protected int area() {
		return (( a * ( b + c )) / 2);
	}
}

class Parallelogram extends Trapezoid {
	public Parallelogram() {
		b = c;
	}
}

class Rectangle extends Parallelogram {
	public Rectangle() {
		b = c;
	}
}

class Square extends Rectangle {
	public Square() {
		a = b = c;
	}
}

class Polygon extends Shape {
	public Polygon() {
		a = b = c = 2;
	}

	protected int area() {
		return (( a * b * c) / 2 );
	}
}

class Pentagon extends Polygon {
	public Pentagon() {
		a = 5;
	}
}

class Hexagon extends Polygon {
	public Hexagon() {
		a = 6;
	}
}

class Heptagon extends Polygon {
	public Heptagon() {
		a = 7;
	}
}

/*	Output from Shape.java
	
	The area of a Trapezoid is 4
	The area of a Parallelogram is 4
	The area of a Rectangle is 4
	The area of a Square is 4
	The area of a Polygon is 4
	The area of a Pentagon is 10
	The area of a Hexagon is 12
	The area of a Heptagon is 14

*/
