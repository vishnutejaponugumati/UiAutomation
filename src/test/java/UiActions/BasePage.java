package UiActions;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

/**
 * The Class BasePage every Page should extend this class.
 *
 */
public class BasePage {

	protected WebDriver driver;

	protected FluentWait<WebDriver> waiter;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
				.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
	}

}
