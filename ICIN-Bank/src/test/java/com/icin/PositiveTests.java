package com.icin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

	@Test
	public void loginTest() throws Exception {
		System.out.println("Starting login test");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		sleep(3000);
		driver.manage().window().maximize();
		String url = "http://localhost:8085/index";
		driver.get(url);
		System.out.println("Page is Opened");
		sleep(3000);
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("test");
		sleep(1500);

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("test");
		sleep(3000);

		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		sleep(5000);

		String expectedurl = "http://localhost:8085/userFront";
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl, "Actual page url is not the same as expected");

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

