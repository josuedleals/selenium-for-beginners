package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
	@Test
	public void loginTest() {
String expectedMessage = "Your username is invalid!";
		ChromeDriver driver = new ChromeDriver();

		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("opening page");
		driver.manage().window().maximize();

		WebElement user = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		user.sendKeys("invalid user");
		password.sendKeys("invalid password");
		WebElement loginButton = driver.findElement(By.tagName("button"));
		
		
		loginButton.click();

		WebElement failMessage = driver.findElement(By.id("flash"));
		
		Assert.assertEquals(failMessage, expectedMessage, "Incorrect message");
		
		//tomsmith
		//SuperSecretPassword!
		
		
		driver.quit();
	}

}
