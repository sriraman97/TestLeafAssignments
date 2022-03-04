package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Sriraman");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]//a")).click();
		
		if(driver.getTitle().contains("View Lead")) {
			driver.findElement(By.linkText("Edit")).click();
			String updatedCompanyName = "Accenture";
			WebElement elementCompanyName = driver.findElement(By.id("updateLeadForm_companyName"));
			elementCompanyName.clear();
			elementCompanyName.sendKeys(updatedCompanyName);
			
			/*
			 * while(elementCompanyName.getAttribute("value").length() > 0)
			 * elementCompanyName.sendKeys(Keys.BACK_SPACE );
			 * elementCompanyName.sendKeys(updatedCompanyName);
			 */
			
			driver.findElement(By.xpath("(//input[@value='Update'])")).click();
			
			if(driver.findElement(By.id("viewLead_companyName_sp")).getText().contains(updatedCompanyName))
				System.out.println("Update lead success..");
			else
				System.out.println("Failed to update lead");
		}
		else
			System.out.println("Problem in loading View Lead page");
		
		Thread.sleep(2000);
		driver.close();
	}

}
