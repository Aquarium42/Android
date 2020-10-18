package tasks;

import java.util.Random;
/**
 * Напишите класс, конструктор которого принимает два массива:
 * массив значений и массив весов значений.
 * Класс должен содержать метод, который будет возвращать элемент
 * из первого массива случайным образом, с учётом его веса.
 * Пример:
 * Дан массив [1, 2, 3], и массив весов [1, 2, 10].
 * В среднем, значение «1» должно возвращаться в 2 раза реже,
 * чем значение «2» и в десять раз реже, чем значение «3».
 */
class RandomFromArray {
	Random random = new Random();
	int [] elements;
	public RandomFromArray(int [] data, int [] weight) {
		int n = 0;
		for (int i: weight) {
			n += i;
		}
		elements = new int[n];
		int index = 0;
		for (int i = 0; i < weight.length; i++) {
			for (int j = 0; j < weight[i]; j++) {
				elements[index] = data[i];
				index += 1;
			}
		}
	}
	public int getRandomElement() {
		int pos = random.nextInt(elements.length);
		return elements[pos];
    
	}
	public void getElements() {
		for (int i: elements) {
			System.out.println(i);
		}
	}
}

public class Task05 {
	 public static void main(String[] args) {
		 int array1[] = {1,3,6};
		 int array2[] = {5,2,8};
	 RandomFromArray r = new RandomFromArray(array1, array2);
	// r.getElements();
     System.out.println(r.getRandomElement());
	 }
}
