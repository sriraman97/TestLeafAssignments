package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5_ExplicitWait_Invisible {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/disapper.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("btn")))); //wait until the button disappears
		System.out.println(driver.findElement(By.xpath("//div[@id='show']//strong")).getText());
		
		File tempScreenShot = driver.getScreenshotAs(OutputType.FILE);
		File sortTable = new File("./snaps/invisible.jpg");
		FileUtils.copyFile(tempScreenShot, sortTable);
	}

}
