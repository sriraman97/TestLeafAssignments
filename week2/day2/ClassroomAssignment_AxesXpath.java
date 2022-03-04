package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomAssignment_AxesXpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup(); //setup the driver
		ChromeDriver driver = new ChromeDriver(); //opening chrome browser
		
		driver.get("http://leaftaps.com/opentaps/control/main"); //load the url
		driver.manage().window().maximize(); //make browser window as full screen
		
		WebElement elementUserName = driver.findElement(By.xpath("//input[@id='username']"));
		elementUserName.sendKeys("Demosalesmanager");
		
		WebElement elementPassword = driver.findElement(By.xpath("//input[@id='password']"));
		elementPassword.sendKeys("crmsfa");
		
		WebElement elementLoginButton = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		elementLoginButton.click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click(); 
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		
		driver.findElement(By.xpath("((//label[text()='First name:'])[3]/following-sibling::div)[1]/input")).sendKeys("Test");
		
		
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]//a")).click();
		
		driver.findElement(By.xpath("(//div[@class='frameSectionExtra'])[2]/a[text()='Edit']")).click();
		WebElement elementCompanyNameTextBox = driver.findElement(By.id("updateLeadForm_companyName"));
		elementCompanyNameTextBox.clear();
		
		String updatedCompanyName = "AbC";
		
		elementCompanyNameTextBox.sendKeys(updatedCompanyName);
		
		driver.findElement(By.className("smallSubmit")).click();
		boolean isCompanyNameUpdated = driver.findElement(By.id("viewLead_companyName_sp")).getText().contains(updatedCompanyName);
		
		System.out.println(isCompanyNameUpdated ? "Company name Successfully updated" : "Failure");

	}

}
