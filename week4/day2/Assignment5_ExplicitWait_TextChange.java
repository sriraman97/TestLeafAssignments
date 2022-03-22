package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5_ExplicitWait_TextChange {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBe(By.id("btn"), "Click ME!"));
		driver.findElement(By.id("btn")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText().equals("Click ME!") ? "Validation success" : "Failure");
		
		File tempScreenShot = driver.getScreenshotAs(OutputType.FILE);
		File sortTable = new File("./snaps/textChange.jpg");
		FileUtils.copyFile(tempScreenShot, sortTable);
		
		alert.accept();
		
	}

}
