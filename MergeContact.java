package week4.day1.homeassignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	
	
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		MergeContact obj = new MergeContact();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		
		List<String> set = obj.set(driver.getWindowHandles());
		
		driver.switchTo().window(set.get(1));
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).click();
		driver.switchTo().window(set.get(0));
		
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//img)[2]")).click();
		
		List<String> set2 = obj.set(driver.getWindowHandles());
		
		driver.switchTo().window(set2.get(1));
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[5]")).click();
		driver.switchTo().window(set2.get(0));
		
		driver.findElement(By.linkText("Merge")).click();
		
		driver.switchTo().alert().accept();
		
		String title = driver.getTitle();
		
		System.out.println("Title of the Page: "+title);
		
	}
	
	public List<String> set(Set<String> windowHandles )
	{	
		
		List<String> wind = new ArrayList<String>(windowHandles);
		return wind;
		
	} 

}
