package week4.day1.homeassignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Window obj = new Window();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("//button[@onClick='openWindows()']")).click();
		
		List<String> set = obj.set(driver.getWindowHandles());
		int siz = set.size()-1;
		System.out.println("Number of Windows Opened: "+siz);
		
		driver.switchTo().window(set.get(2)).close();
		driver.switchTo().window(set.get(1)).close();
		
		
		
		
		
	}
	
	public List<String> set(Set<String> windowHandles )
	{	
		
		List<String> wind = new ArrayList<String>(windowHandles);
		return wind;
		
	} 

}
