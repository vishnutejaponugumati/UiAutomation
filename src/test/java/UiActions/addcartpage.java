package UiActions;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class addcartpage extends BasePage {

	public addcartpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "user-name")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//*[@id='login-button']")
	private WebElement login;
	
	@FindBy(className = "product_sort_container")
	private WebElement sort;
	@FindAll({
	@FindBy(xpath = "//button[text()='Add to cart']")
	})
	private List<WebElement> addcart;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement shippng;

	@FindBy(xpath = "//button[@id=\"checkout\"]")
	private WebElement checkout;
	
public addcartpage addCart() throws InterruptedException {
	// TODO Auto-generated method stub
	username.sendKeys("standard_user");
	password.sendKeys("secret_sauce");
	Thread.sleep(2000);
	login.click();
	
	Select select = new Select(sort);
	select.selectByVisibleText("Price (high to low)");
	Thread.sleep(2000);

	//driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
	List<WebElement> list = addcart;
	for (int i = 0; i < list.size(); i++) {
		list.get(i).click();
		Thread.sleep(1000);
	}
	Thread.sleep(2000);

	shippng.click();
	Thread.sleep(2000);

	checkout.click();
	Thread.sleep(2000);
	return this;
}
	
/*
	driver.findElement(By.xpath("//input[@id=\"first-name\"]")).sendKeys("TestName");
	driver.findElement(By.xpath("//input[@id=\"last-name\"]")).sendKeys("Last Name");
	driver.findElement(By.xpath("//input[@id=\"postal-code\"]")).sendKeys("500072");
	Thread.sleep(2000);

	driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("//button[@id=\"finish\"]")).click();
	Thread.sleep(2000);

	String statusText = driver.findElement(By.xpath("//h2")).getText();
	
	driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[@id=\"logout_sidebar_link\"]")).click();
	*/
}
