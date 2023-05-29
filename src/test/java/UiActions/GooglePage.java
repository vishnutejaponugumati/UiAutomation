package UiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GooglePage extends BasePage {
	
	
	@FindBy(name = "q")
	private WebElement searchinput;

	
	public GooglePage(WebDriver driver) {
		super(driver);
	}

	
	public void searchText(String key) {
		searchinput.sendKeys(key + Keys.ENTER);
	}
	public void test(WebDriver driver) {
		driver.findElement(By.xpath(null)).click();
	}

}
