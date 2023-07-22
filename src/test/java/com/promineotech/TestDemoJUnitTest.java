package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	private TestDemo testDemo;

	/**
	 * 
	 * @throws Exception
	 * 
	 *                   Sets up a new instance variable of the TestDemo class
	 *                   before each test is run.
	 */
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	/**
	 * Create a mocked version of the instance variable testDemo. When getRandomInt
	 * is called on mockDemo, return 5 instead of a random number. Call
	 * randomNumberSquared on mockDemo (which is returning 5 for the random number).
	 * Assert that 5^2 is 25 as returned by the method.
	 */
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);

		doReturn(5).when(mockDemo).getRandomInt();

		int fiveSquared = mockDemo.randomNumberSquared();

		assertThat(fiveSquared).isEqualTo(25);
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param expected
	 * @param expectException
	 * 
	 *                        Creates Parameterized Test that tests that the first
	 *                        value (a) is bigger than the second value (b) and that
	 *                        the method from TestDemo works as expected. If b > a,
	 *                        then tests that the method throws an
	 *                        IllegalArgumentException. If expectException is TRUE
	 *                        then it expects the exception to be thrown.
	 */
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForSubtractSmallFromBig")
	void assertThatASmallerNumberIsSubtractedFromABiggerNumber(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.subtractSmallFromBig(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.subtractSmallFromBig(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	/**
	 * 
	 * @return
	 * 
	 *         Inputs the arguments that are used as parameters for the
	 *         parameterized test above.
	 */
	static Stream<Arguments> argumentsForSubtractSmallFromBig() {
		// @formatter:off
		return Stream.of(
			arguments(3, 2, 1, false),
			arguments(2, 3, -1, true),
			arguments(3, -1, 4, false),
			arguments(-1, -2, 1, false),
			arguments(-2, -1, -1, true),
			arguments(2, 2, 0, true)
		);
				
		// @formatter:on
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPostive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPostive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForAddPositive() {
		// @formatter:off
		return Stream.of(
			arguments(3, 4, 7, false),
			arguments(-2, 5, 3, true),
			arguments(2, -5, -3, true),
			arguments(2, 0, 2, true),
			arguments(0, 3, 3, true)
			
		);
		// @formatter:on
	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPostive(7, 6)).isEqualTo(13);
		assertThat(testDemo.addPostive(3, 55)).isEqualTo(58);
	}

}
