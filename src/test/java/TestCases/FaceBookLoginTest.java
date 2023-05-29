package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.PageinstancesFactory;
import UiActions.FacebookLoginPage;

/**
 * The Class FaceBookLoginTest.
 *
 */
@Test(testName = "Facebook login test", description = "Facebook login test")
public class FaceBookLoginTest extends BaseTest {

	@Test
	public void facebookLoginTest() {
		driver.get("https://www.facebook.com/");
		FacebookLoginPage facebookLoginPage = PageinstancesFactory.getInstance(FacebookLoginPage.class);
		//facebookLoginPage.enterEmail("abc").enterPassword("abc").clickSignIn();
		facebookLoginPage.enterEmail("abc");
		facebookLoginPage.enterPassword("abc");
		facebookLoginPage.clickSignIn();
		Assert.assertTrue(false, "Login failed : Test failed");
	}
}
