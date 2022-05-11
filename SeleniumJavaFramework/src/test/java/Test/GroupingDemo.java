package Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(groups= {"AllClassTests"})
public class GroupingDemo {
	
	@BeforeTest(alwaysRun=true)
	public void setUp() {
		System.out.println("This is Set up mtd");
	}
	
	@Test(groups={"sanity"})
	public void test1()
	{
		System.out.println("This is Test1");
	}
	
	@Test(groups={"smoke","sanity"})
	public void test2()
	{
		System.out.println("This is Test2");
	}

	@Test(groups={"sanity","regression"})
	public void test3()
	{
		System.out.println("This is Test3");
	}
	
	@Test(groups={"regression1"})
	public void test4()
	{
		System.out.println("This is Test4");
	}
	
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		System.out.println("This is tear down mtd");
	}
}
