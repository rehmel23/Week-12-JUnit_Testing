package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPostive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * 
	 *         If a is bigger than b, subtract. Otherwise, throw an
	 *         IllegalArgumentException with message.
	 */
	public int subtractSmallFromBig(int a, int b) {
		if (a > b) {
			return a - b;
		} else {
			throw new IllegalArgumentException("The 1st parameter must be greater than the 2nd parameter!");
		}
	}

	/**
	 * 
	 * @return
	 * 
	 *         Calls getRandomInt to obtain a number between 1 and 10 and assigns it
	 *         to num. Returns the value of num squared.
	 */
	public int randomNumberSquared() {
		int num = getRandomInt();

		return num * num;

	}

	/**
	 * 
	 * @return
	 * 
	 *         Creates an instance variable of the Random class. Calls nextInt(int
	 *         bounds) method in the random class.
	 */
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
