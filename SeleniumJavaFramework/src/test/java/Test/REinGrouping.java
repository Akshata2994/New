package Test;

import org.testng.annotations.Test;

public class REinGrouping {
	@Test(groups={"windows.sanity"})
	public void test1()
	{
		System.out.println("This is Test1");
	}
	
	@Test(groups={"smoke","linux.regression"})
	public void test2()
	{
		System.out.println("This is Test2");
	}

	@Test(groups={"windows.sanity","linux,smoke"})
	public void test3()
	{
		System.out.println("This is Test3");
	}
	
	@Test(groups={"regression"})
	public void test4()
	{
		System.out.println("This is Test4");
	}

}
