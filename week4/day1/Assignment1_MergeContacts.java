package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_MergeContacts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click(); //login
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("(//ul[@class='shortcuts']/li)[4]")).click();//click Merge contacts
		driver.findElement(By.xpath("(//td[@class='titleCell'])[1]/following-sibling::td/a")).click(); //click on the widget icon
		
		Set<String> setOfWindowHandles = driver.getWindowHandles();
		List<String> listOfWindowHandles = new ArrayList<String>(setOfWindowHandles);//store all window handles in a list for retrival
		driver.switchTo().window(listOfWindowHandles.get(1)); //switch to window(from contact)
//		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]//a")).click();//click on the 1st resultant contact
		
		driver.switchTo().window(listOfWindowHandles.get(0)); //switch back to root window
		driver.findElement(By.xpath("(//td[@class='titleCell'])[2]/following-sibling::td/a")).click(); //click on widget icon(To contact)
		listOfWindowHandles.clear(); //clear the list
		
		listOfWindowHandles.addAll(driver.getWindowHandles());
		driver.switchTo().window(listOfWindowHandles.get(1)); //switch to window(to contact)
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();//click on 2nd resulting contact
		driver.switchTo().window(listOfWindowHandles.get(0));
		
		driver.findElement(By.linkText("Merge")).click(); //click on merge button
		
		Alert mergeConfirmationAlert = driver.switchTo().alert();
		mergeConfirmationAlert.accept();
		System.out.println(driver.getTitle().equals("View Contact | opentaps CRM")? "Merge success": "Failed to merge");
	}

}
