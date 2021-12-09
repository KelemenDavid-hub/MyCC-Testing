package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashBoardPage;
import pages.LogInPage;

public class LogInTests extends BaseTest{
	
	@Test(groups = "end2end", priority = 1)
	public void testLogIn() {
		
		
		DashBoardPage dashboardpage = loginPage.clickSignInButton(null, null);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
