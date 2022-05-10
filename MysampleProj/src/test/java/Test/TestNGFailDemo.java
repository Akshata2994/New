package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGFailDemo {
	
	@Test
	public void test1()
	{
		System.out.println("This is Test1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("This is Test2");
	}

	@Test(retryAnalyzer=Listeners.RetryInterface.class)
	public void test3()
	{
		System.out.println("This is Test3");
		Assert.assertTrue(false);
	}
}
