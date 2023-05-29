package UiActions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Context.WebDriverContext;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	// code extract USER
	
	static String Username = "standard_user";
	public WebDriver driver;
	public void launchBrowser() throws InterruptedException, IOException  {
		//System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("disable-infobars");
		driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverContext.setDriver(driver);
		
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@data-test=\"username\"]")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("Screenshots\\HomePage12.png");
		FileUtils.copyFile(SrcFile, DestFile);	
		//driver.quit();
		}
}


//Tag[@TYpe="value"]