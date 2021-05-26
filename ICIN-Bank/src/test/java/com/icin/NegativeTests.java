package com.icin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

	@Test
	public void incorrectUsernameTest() {
		System.out.println("Starting incorrect user name test");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		sleep(3000);

		driver.manage().window().maximize();
		String url = "http://localhost:8085/index";
		driver.get(url);
		System.out.println("Page is opened");

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("incorrectUsername");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("test");

		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		sleep(3000);

		WebElement errorMessage = driver.findElement(By.xpath("/html/body//div[@class='bg-danger']"));
		String expectedErrorMessage = "Invalid username and secret.";
		String actualErrorMessage = errorMessage.getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual error message doesn not contain expected .\nActual:" + actualErrorMessage + "\nExpected:"
						+ expectedErrorMessage);
		driver.quit();
	}

	@Test
	public void incorrectPasswordTest() {
		System.out.println("Starting Incorrect Password Test");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		sleep(3000);

		driver.manage().window().maximize();
		String url = "http://localhost:8085/index";
		driver.get(url);
		System.out.println("Page is opened");

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("test");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("incorrectPassword");

		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		sleep(3000);

		WebElement errorMessage = driver.findElement(By.xpath("/html/body//div[@class='bg-danger']"));
		String expectedErrorMessage = "Invalid username and secret.";
		String actualErrorMessage = errorMessage.getText();

		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual error message does not contain expected. \nActual:" + actualErrorMessage + "\nExpected:"
						+ expectedErrorMessage);
		driver.quit();
	}

	private void sleep(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
