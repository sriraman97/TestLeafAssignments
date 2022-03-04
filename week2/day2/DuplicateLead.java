package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("nsriraman97@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		
		WebElement elementFirstResultantLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		String firstLeadName = elementFirstResultantLead.getText();
		elementFirstResultantLead.click();
		
		driver.findElement(By.linkText("Duplicate Lead")).click();//click duplicate button
		
		if(driver.getTitle().contains("Duplicate Lead")) {
			driver.findElement(By.className("smallSubmit")).click(); //click create lead button
			
			if(driver.findElement(By.id("viewLead_firstName_sp")).getText().equals(firstLeadName)) //verify the name
				System.out.println("Duplicate lead success");
			else
				System.out.println("Failed to duplicate lead");
		}
		else
			System.out.println("Page title verification failed");
		
		Thread.sleep(2000);
		driver.close();
	}

}
