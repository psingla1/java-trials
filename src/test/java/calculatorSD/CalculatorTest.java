package calculatorSD;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	private Calculator calculator = new Calculator();
	
	@Test
	public void shouldEvaluateConstants() {
		int result = calculator.evaluate("1");
		assertEquals(1, result);
	}
	
	@Test
	public void shouldSupportAdding() {
		int result = calculator.evaluate("1 + 2");
		assertEquals(3, result);
	}
	
	@Test
	public void shouldSupportSubstraction() {
		int result = calculator.evaluate("1 - 2");
		assertEquals(-1, result);
	}
	
	@Test
	public void shouldSupportComplexStatements() {
		int result = calculator.evaluate("1 - 3 + 2 + 4");
		assertEquals(4, result);
	}
}
