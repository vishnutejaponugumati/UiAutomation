package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import UiActions.LaunchBrowser;
@Test(testName = "Launch browser test", description = "Test description")

public class LaunchBrowserTest extends BaseTest {
	// code extract USER
	@Test
	public void launch() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		LaunchBrowser lb = new LaunchBrowser();
		lb.launchBrowser();
		
	}
	
}




//Tag[@TYpe="value"]