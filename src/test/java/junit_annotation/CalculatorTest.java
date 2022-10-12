package junit_annotation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	Calculator calculator;
	@Before
	public void initial()
	{
		calculator=new Calculator();
	}
	@Test
	public void testMultiply()
	{
		assertEquals(20, calculator.multiply(4, 5));
	}
	@Test
	public void testAdd()
	{
		assertEquals(9, calculator.add(4, 5));
	}
	@Test
	public void testDivide()
	{
		assertEquals(5, calculator.divide(10, 2));
	}
	@Test
	public void testSub()
	{
		assertEquals(1, calculator.subtract(5, 4));
	}
}
