package Test;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class TestNGdependency {

	
	@Test(dependsOnMethods= {"test2"})
	public void test1()
	{
		System.out.println("Inside Test1");
	}
	
	
	@Test(dependsOnMethods= {"test3"})
	public void test2()
	{
		//Assert.fail("just to skip the other test");
		System.out.println("Inside Test2");
	}
	
	@Test
	public void test3()
	{
		System.out.println("Inside Test3");
	}
	
	@Test
	
	public void test4()
	{
		System.out.println("Inside Test4");
	}
}
