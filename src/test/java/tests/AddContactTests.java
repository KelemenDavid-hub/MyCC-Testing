package tests;

import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashBoardPage;
import pages.ProfilePage;

public class AddContactTests extends BaseTest {

	@Test(groups = "end2end", priority = 1)
	@Parameters({ "email", "password", "firstName", "lastName", "phoneNumber", "eMail" })

	public void testAddContact(String email, String password, String firstName, String lastName, String phoneNumber,
			String eMail) { //successful if there is no contact

		setTimestamp("testAddContact");
		DashBoardPage dashboardPage = loginPage.clickSignInButton(email, password);
		ProfilePage profilPage = dashboardPage.goToProfilePage();

		profilPage.clickAddContactButton();
		profilPage.setFirstName(firstName);
		profilPage.setLastName(lastName);
		profilPage.setPhoneNumber(phoneNumber);
		profilPage.setEmail(eMail);
		profilPage.clickOtherOption();
		profilPage.clickSaveButton();
		Assert.assertTrue(profilPage.getSuccesfulContactMessage().contains("Contact created successfully!"));
		long maxDuration = 20000L;
		Assert.assertTrue(maxDuration >= getDurationInMillisFrom("testAddContact"));

	}
	

	@Test(groups = "end2end", priority = 2)
	@Parameters({ "email", "password", "firstName", "lastName", "phoneNumber", "eMail" }) //successful if there is atleast one contact

	public void testAddNewContact(String email, String password, String firstName, String lastName, String phoneNumber,
			String eMail) {

		setTimestamp("testAddNewContact");
		DashBoardPage dashboardPage = loginPage.clickSignInButton(email, password);
		ProfilePage profilPage = dashboardPage.goToProfilePage();

		profilPage.clickAddNewContactButton();
		profilPage.setFirstName(firstName+"V2");
		profilPage.setLastName(lastName+"V2");
		profilPage.setPhoneNumber(phoneNumber+"911");
		profilPage.setEmail(eMail+"gibberish");
		profilPage.clickOtherOption();
		profilPage.clickSaveButton();
		Assert.assertTrue(profilPage.getSuccesfulContactMessage().contains("Contact created successfully!"));
		long maxDuration = 20000L;
		Assert.assertTrue(maxDuration >= getDurationInMillisFrom("testAddNewContact"));

	}
	
	/* 1.Name fields also accept numbers and special characters
	 * 2.Phone number field accepts non-numerical values and also more than 10 digits
	 * 3.Email is accepted as long as it contains @.something
	*/

}
