package com.solution.elements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class HandlePagination 

{

public static void main(String[] args) throws InterruptedException {
	

    	System.setProperty("webdriver.chrome.driver", "config\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    	driver.navigate().to("https://localhost:8443/changemanagement/home.spg");
    	//driver.navigate().to("javascript:document.getElementById('overridelink').click()");
    	//driver.navigate().to("javascript:document.getElementById('overridelink').click()");
    	driver.findElement(By.xpath("//label[text()='Username']//following-sibling::*")).sendKeys("Admin");
    	driver.findElement(By.xpath("//label[text()='Password']//following-sibling::*")).sendKeys("Admin");
    	driver.findElement(By.xpath("//input[@type='submit']")).click();
    	/*
    	 //start of first approach
    	 * In my case paginatio  has ellipses in it
    	 * List list = driver.findElements(By.xpath("//div[@id='tasksTable_paginate']/span/a"));
    	int index = list.size();
    	String lastindex = driver.findElement(By.xpath("//div[@id='tasksTable_paginate']/span/a["+ index +"]")).getText();
    	//System.out.println(lastindex);
    	int lastpage = Integer.parseInt(lastindex);
    	for(int i=1;i<=lastpage;i++)
    	{
    		driver.findElement(By.xpath("//a[text()='"+i+"']")).click();
    		Thread.sleep(1000);
    		
    	}
    	//start of first approach
    	*/
    	
    	//start of second approach
    	while(true)
    	{
    		if(driver.findElement(By.xpath("//a[text()='Next']")).getAttribute("class").contains("disabled"))
    		{
    			List table = driver.findElements(By.xpath("//table[@id='tasksTable']/tbody/tr"));
        		System.out.println(table.size());
        		System.out.println(driver.findElement(By.xpath("//table[@id='tasksTable']/tbody/tr/td[5]")).getText());
    			break;
    		}
    		List table = driver.findElements(By.xpath("//table[@id='tasksTable']/tbody/tr"));
    		System.out.println(table.size());
    		System.out.println(driver.findElement(By.xpath("//table[@id='tasksTable']/tbody/tr/td[5]")).getText());
    		driver.findElement(By.xpath("//a[text()='Next']")).click();
    		Thread.sleep(1000);
    		
    	}
    	//end of second approach
    	driver.quit();
    	
    	
    	
    }
    
}
