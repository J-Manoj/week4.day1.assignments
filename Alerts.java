package week4.day1.homeassignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Prompt Box");
		alert.accept();
		
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
	
		
		
	}
	
	

}
