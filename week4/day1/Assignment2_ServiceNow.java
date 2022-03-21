package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_ServiceNow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev79285.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Mar@2k22");
		driver.findElement(By.id("sysverb_login")).click();
		
		driver.findElement(By.id("filter")).sendKeys("incident"); //search incident in filter navigator
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click(); //click ALL
		driver.switchTo().frame(0);
		driver.findElement(By.id("sysverb_new")).click(); //click on New button
		driver.findElement(By.id("lookup.incident.caller_id")).click(); //click on search button (for caller)
		Set<String> setOfWindows = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(setOfWindows);
		driver.switchTo().window(listOfWindows.get(1)); //switch to window to select caller
		driver.manage().window().maximize();	
		
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();//click on 1st resulting caller name
		driver.switchTo().window(listOfWindows.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.id("incident.short_description")).sendKeys("some random short desc goes here...."); //give some short desc
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value"); //store incident number
		System.out.println("Incident number " + incidentNumber);
		driver.findElement(By.id("sysverb_insert")).click(); //click submit
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber, Keys.ENTER);//search the incident
		
		String xPath = "//a[text()='" + incidentNumber + "']";
		driver.findElement(By.xpath(xPath)).click(); //click on the resultant incident number(which weve created)
		
		File tempScreenshot = driver.getScreenshotAs(OutputType.FILE); //take a snapshot of the current screen, 
		File image = new File("./snaps/img001.jpg"); //create new file in the snaps folder(created as a new folder)
		FileUtils.copyFile(tempScreenshot, image);//windows operation
		
	}

}
