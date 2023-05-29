package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.PageinstancesFactory;
import UiActions.FacebookLoginPage;
import UiActions.addcartpage;

/**
 * The Class FaceBookLoginTest.
 *
 */
@Test(testName = "Add cart test", description = "Add Cart test")
public class AddcartTest extends BaseTest {

	@Test
	public void addcart() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		addcartpage addcartPage = PageinstancesFactory.getInstance(addcartpage.class);
		addcartPage.addCart();
		Assert.assertTrue(true, "Login failed : Test Passed");
		//driver.quit();
	}
}
