package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.PageinstancesFactory;
import UiActions.GooglePage;

/**
 * The Class GoogleSearchTest.
 *
 */
@Test(testName = "Google search test", description = "Test description")
public class GoogleSearchTest extends BaseTest {

	/**
	 * Google search test.
	 */
	@Test
	public void googleSearchTest() {
		driver.get("https://www.google.co.in/");
		GooglePage googlePage = PageinstancesFactory.getInstance(GooglePage.class);
		googlePage.searchText("abc");
		Assert.assertTrue(driver.getTitle().contains("abc"), "Title doesn't contain abc : Test Failed");
	}
}
