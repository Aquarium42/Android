package tasks;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import tasks.Vector;

public class Task04Test {

	Vector vector = new Vector(1.2, 2.3, 5.3);
	Vector vector2 = new Vector(3.1, -5.2, 0.3);
	double eps = 0.001;
	@Test
	public void lengthTest() {	
		 Assert.assertEquals(5.9008474, vector.length(), eps);
	}

	@Test
	public void dotTest() {	
		 Assert.assertEquals(-6.65, vector.dotProduct(vector2), eps);
	}
	
	@Test
	public void crossTest() {	
		Vector vector_ans = new Vector(28.25, 16.07, -13.37);
		Vector calculated = vector.crossProduct(vector2);
		 Assert.assertEquals(true, calculated.equals(vector_ans));
	}
	@Test
	public void cosAlphaTest() {	
		 Assert.assertEquals(-0.18592495537745216, vector.cosAlpha(vector2) ,eps);
	}
	
	@Test
	public void addTest() {	
		Vector result = new Vector(4.3, -2.9, 5.6);
		 Assert.assertEquals(true, result.equals(vector.add(vector2)));
	}

	@Test
	public void subTest() {	
		Vector result = new Vector(-1.9, 7.5, 5);
		 Assert.assertEquals(true, result.equals(vector.substract(vector2)));
	}
}
