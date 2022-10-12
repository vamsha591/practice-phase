package junit_annotation;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InVoiceTest {
	int GST=28;
	@BeforeClass
	public static void On()
	{
		System.out.println("Billing software is On");
	}
	@Before
	public void login()
	{
		System.out.println("Welcome to E-CART");
	
	}
	@Test
	public void testGST()
	{
		System.out.println("Test GST for product 1");
		assertEquals(GST, 99);
	}
	
	@Test
	public void testGST1()
	{
		System.out.println("Test GST for product 2");
		assertEquals(GST, 28);
	}
	@After
	public void logout()
	{
		System.out.println("Tq 4 u'r visit");
	}
	@AfterClass
	public static  void  Off()
	{
		System.out.println("Billing software shutting off");
	}
}
