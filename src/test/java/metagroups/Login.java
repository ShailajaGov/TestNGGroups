package metagroups;

import org.testng.annotations.Test;

public class Login {
	
	@Test(priority = 1,groups = {"smoke","sanity","login","All"})
	public void verifyLoginWithValidCredentials()
	{
		System.out.println("verifyLoginWithValidCredentials");
	}
	
	@Test(priority = 2,groups = {"sanity","login","All"})
	public void verifyLoginWithValidEmailAndInvalidPwd()
	{
		System.out.println("verifyLoginWithValidEmailAndInvalidPwd");
		
	}
	
	@Test(priority = 3,groups = {"login","All"})
	public void verifyLoginWithInvalidEmailAndValidPwd()
	{
		System.out.println("verifyLoginWithInvalidEmailAndValidPwd");
	}
	
	@Test(priority = 4,groups = {"smoke","All"})
	public void verifyLoginWithInvalidCredentials() 
	{
		System.out.println("verifyLoginWithInvalidCredentials");
	}
	
	@Test(priority = 1,groups = {"All"})
	public void verifyLoginWithoutGivingAnyCredentials()
	{
		System.out.println("verifyLoginWithoutGivingAnyCredentials");
	}

}
