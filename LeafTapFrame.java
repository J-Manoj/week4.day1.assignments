package week4.day1.homeassignments;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapFrame {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		System.out.println("Switched to Frame 1");
		File src = driver.findElement(By.id("Click")).getScreenshotAs(OutputType.FILE);
		File des = new File("./Element Screenshot1.png");
		FileUtils.copyFile(src, des);
		
		driver.switchTo().defaultContent();
		List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		int siz = findElements.size();
		System.out.println("Total Frames Present: "+siz);
	}

}
