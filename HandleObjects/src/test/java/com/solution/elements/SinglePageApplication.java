package com.solution.elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SinglePageApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "config\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.servicenow.com");
		/* first approach id name this did not work
		//driver.navigate().to("https://www.servicenow.com#valueofID");
		 */
		
		WebElement element = driver.findElement(By.xpath("//div[@id='sn-footer-left-combo']/div[2]/div[2]/ul/li[1]/a"));
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		/* second approach
		//e//xecutor.executeScript("scroll(0,"+Integer.MAX_VALUE+")");
	   */
		/* third approach*/
	     executor.executeScript("window.scrollTo(0,"+element.getLocation().y+")");
		 element.click();
		 
		
		 
	}

}
 