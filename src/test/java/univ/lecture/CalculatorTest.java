package univ.lecture;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.*;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class CalculatorTest {
	@Test
	public void testCalculatorAdd() {
		Calculator calc = new Calculator();
		int output = calc.calculate("1+1");
		assertThat(output, is(2));
	}

	@Test
	public void testCalculatorSub() {
		Calculator calc = new Calculator();
		int output = calc.calculate("2-4");
		assertThat(output, is(-2));
	}

	@Test
	public void testCalculatorMul() {
		Calculator calc = new Calculator();
		int output = calc.calculate("(2+6)*2");
		assertThat(output, is(16));
	}

	@Test
	public void testCalculatorDiv() {
		Calculator calc = new Calculator();
		int output = calc.calculate("8/2");
		assertThat(output, is(4));
	}

    @Test
    public void testCalculatorDivandMul() {
        Calculator calc = new Calculator();
        int output = calc.calculate("(8/2)*3");
        assertThat(output, is(12));
    }
}
