package week4.day1.homeassignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServieNow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		driver.get("https://dev107825.service-now.com");
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Manoj@27");
		driver.findElement(By.id("sysverb_login")).click();
		
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.linkText("All")).click();
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handle = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(handle.get(1));
		driver.findElement(By.xpath("(//table[@id='sys_user_table']//a)[9]")).click();
		driver.switchTo().window(handle.get(0));
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("Short Description");
		String attribute = driver.findElement(By.id("incident.number")).getAttribute("Value");
		System.out.println(attribute);
		driver.findElement(By.id("sysverb_insert")).click();
			
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys(attribute,Keys.ENTER);
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshot.png");
		FileUtils.copyFile(src, des);
		
	}

}
