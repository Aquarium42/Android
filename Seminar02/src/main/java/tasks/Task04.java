package tasks;

/**
 * Реализовать трехмерный вектор.
 * Условие: https://habr.com/ru/post/440436/#20
 * Там есть решение. Сначала попробуйте самостоятельно.
 */
class Vector {
private double x;
private double y;
private double z;
private double eps = 0.001;
public Vector(double x, double y, double z) {
	this.x = x;
	this.y = y;
	this.z = z;
}
public double length() {
	return Math.sqrt(x*x+y*y+z*z);
}
public double dotProduct(Vector v) {
	return x*v.x + y*v.y+z*v.z;
}
public Vector crossProduct(Vector v) {
	Vector result = new Vector(y*v.z-z*v.y, z*v.x-x*v.z, x*v.y-y*v.x);			
	return result;
}
public double cosAlpha(Vector v) {
	return (this.dotProduct(v)/(this.length()*v.length()));
}

public Vector add (Vector v) {
	return new Vector(x+v.x, y+v.y, z+v.z);
}
public Vector substract(Vector v) {
	return new Vector(x-v.x, y-v.y, z-v.z);
}
public boolean equals(Vector v) {
	if ((v.x - x) < eps &&( v.y - y )< eps && (v.z - z )< eps) {
		return true;
	}
	return false;
}
public static Vector[] generateVectors(int n) {
	Vector[] vectorsArray = new Vector[n];
	for (int i = 0; i < n; ++i) {
		vectorsArray[i] = new Vector(Math.random(), Math.random(),Math.random());
	}
	return vectorsArray;
}
}

public class Task04 {

}
