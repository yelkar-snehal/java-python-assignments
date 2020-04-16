package mypackage;

import java.util.InputMismatchException;
import java.util.Scanner;

class CalculateArea {
	final double PI = 3.14159;

	// area of square
	public float calcArea(float a) {
		return a * a;
	}

	// area of rect
	public float calcArea(float a, float b) {
		return a * b;
	}

	// area of circle
	public double calcArea(double a) {
		return PI * a * a;
	}

}

public class CalculateAreaDemo {

	public static void main(String[] args) {
		CalculateArea obj = new CalculateArea();
		float side = 0, len = 0, breadth = 0;
		double radius = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter square side");
		try {
			side = sc.nextFloat();
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("That's not a float!\nThis execption occured\n" + e);
			System.exit(1);
		}
		System.out.printf("Area of sqaure with side %f is : %f\n", side, obj.calcArea(side));

		System.out.println("Enter len and breadth of rectangle");
		try {
			len = sc.nextFloat();
			breadth = sc.nextFloat();
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("That's not a float!\nThis execption occured\n" + e);
			System.exit(1);
		}
		System.out.printf("Area of rectangle with len %f and breadth %f is : %f\n", len, breadth,
				obj.calcArea(len, breadth));

		System.out.println("Enter circle radius");
		try {
			radius = sc.nextDouble();
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("That's not a double!\nThis execption occured\n" + e);
			System.exit(1);
		}
		System.out.printf("Area of circle with radius %f is : %f\n", radius, obj.calcArea(radius));

		sc.close();
	}

}
