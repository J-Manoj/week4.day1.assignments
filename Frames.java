package week4.day1.homeassignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		driver.get(" https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frame1");
		System.out.println("Switched to frame 1");
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("Selenium");
		
		driver.switchTo().frame("frame3");
		System.out.println("Switched to frame 3");
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following::input")).click();
	}

}
