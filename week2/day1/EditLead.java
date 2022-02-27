package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup(); //setup the driver
		ChromeDriver driver = new ChromeDriver(); //opening chrome browser
		
		CreateLead c1 = new CreateLead();
		c1.createLead(driver);
		
		EditLead e1 = new EditLead();
		e1.editLead(driver);
		
		System.out.println("Page Title: " + driver.getTitle());
	}
	
	public void editLead(ChromeDriver driver) {
		
		driver.findElement(By.linkText("Edit")).click();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		System.out.println("After 10 seconds");
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("some important notes here...");
		
		driver.findElement(By.className("smallSubmit")).click();
	}

}
