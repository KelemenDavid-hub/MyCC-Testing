package tests;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashBoardPage;
import pages.MyLeavesPage;

public class RequestLeaveTests extends BaseTest {

	@Test(groups = "end2end", priority = 1)
	@Parameters({ "email", "password" })

	public void testSuccesfulRequestLeaveForHalfDay(String email, String password) {

		setTimestamp("testSuccesfulRequestLeaveForHalfDay");
		DashBoardPage dashBoardPage = loginPage.clickSignInButton(email, password);
		Reporter.log("Succesful login");
		MyLeavesPage leavesPage = dashBoardPage.goToRequestLeavePage();
		Reporter.log("Leaves Page opened.");
		leavesPage.clickRequestRestDaysButton();
		Reporter.log("Request Days Menu opened.");
		leavesPage.clickSkipButton();
		leavesPage.clickHalfDayCheckBox();
		leavesPage.clickColleaguesCheckBox();
		Reporter.log("Checked half day and colleagues checkbox.");
		leavesPage.clickDateRangeText();
		leavesPage.clickTodayButton();
		Reporter.log("Selected day-off");
		leavesPage.clickSaveButton();
		Reporter.log("Request Saved!");
		assertEquals(leavesPage.getSuccesMessage(), "Request created successfully!");
		long maxDuration = 20000L;

		Assert.assertTrue(maxDuration >= getDurationInMillisFrom("testSuccesfulRequestLeaveForHalfDay"));

	}

	@Test(groups = "end2end", priority = 2)
	@Parameters({ "email", "password" })

	public void testUnSuccesfulRequestLeaveForHalfDay(String email, String password) {
		// will fail if I already have a half day off for  / will pass if not
		setTimestamp("testUnSuccesfulRequestLeaveForHalfDay");
		DashBoardPage dashBoardPage = loginPage.clickSignInButton(email, password);
		Reporter.log("Succesful login");
		MyLeavesPage leavesPage = dashBoardPage.goToRequestLeavePage();
		Reporter.log("Leaves Page opened.");
		leavesPage.clickRequestRestDaysButton();
		Reporter.log("Request Days Menu opened.");
		leavesPage.clickSkipButton();
		leavesPage.clickHalfDayCheckBox();
		leavesPage.clickColleaguesCheckBox();
		Reporter.log("Checked half day and colleagues checkbox.");
		leavesPage.clickDateRangeText();
		leavesPage.clickSelectedDay("9");
		Reporter.log("Selected day-off");
		leavesPage.clickSaveButton();
		Reporter.log("Request Saved!");
		assertEquals(leavesPage.getSuccesMessage(), "Request created successfully!");
		long maxDuration = 20000L;

		Assert.assertTrue(maxDuration >= getDurationInMillisFrom("testUnSuccesfulRequestLeaveForHalfDay"));

	}

}
