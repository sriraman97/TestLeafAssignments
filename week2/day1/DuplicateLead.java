package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup(); //setup the driver
		ChromeDriver driver = new ChromeDriver(); //opening chrome browser
		
		CreateLead c1 = new CreateLead();
		c1.createLead(driver);
		
		System.out.println("Page Title after creating a Lead: " + driver.getTitle());
		
		DuplicateLead d1 = new DuplicateLead();
		d1.duplicateLead(driver);
		
		System.out.println("Page Title after duplicating a lead: " + driver.getTitle());
	}
	
	public void duplicateLead(ChromeDriver driver) {
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
		elementCompanyName.clear();
		elementCompanyName.sendKeys("Test Leaf");
		
		WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
		elementFirstName.clear();
		elementFirstName.sendKeys("SRIRAMAN");
		
		driver.findElement(By.className("smallSubmit")).click();
		
	}

}
