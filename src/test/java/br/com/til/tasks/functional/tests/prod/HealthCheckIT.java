package br.com.til.tasks.functional.tests.prod;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HealthCheckIT {
	
	private static final String BUILD = "build";

	@Test
	public void testHelthCheck() {
		
		System.setProperty("webdriver.chrome.driver", "/Volumes/Macintosh HD/Projetos/Devops/chromedriver");
		WebDriver webDriver = new ChromeDriver();
		
//		 DesiredCapabilities cap = DesiredCapabilities.chrome();
//		 WebDriver webDriver = new RemoteWebDriver(new URL("http://192.168.0.8:4444/wd/hub"), cap );
		 
		try {
			
//			webDriver.navigate().to("http:/192.168.15.3.:8003/tasks");
			webDriver.navigate().to("http:/192.168.0.6:8003/tasks");
			
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String version = webDriver.findElement(By.id("version")).getText();
			
			Assert.assertTrue(version.startsWith(BUILD));
			
		} finally {
			webDriver.quit();
			
		}
		
	}
}
