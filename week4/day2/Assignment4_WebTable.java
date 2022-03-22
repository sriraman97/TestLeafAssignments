package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_WebTable {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement elementWebTable = driver.findElement(By.id("table_id"));
		System.out.println("No. of columns: " + elementWebTable.findElements(By.tagName("th")).size());
		List<WebElement> listOfRows = elementWebTable.findElements(By.tagName("tr"));
		System.out.println("No. of rows: " + listOfRows.size());
		List<Integer> progress = new ArrayList<Integer>();
		
		for (WebElement row : listOfRows) {
			List<WebElement> listOfData = row.findElements(By.tagName("td"));
			if(listOfData != null && ! listOfData.isEmpty()) { 
				progress.add(Integer.parseInt(listOfData.get(1).getText().replaceAll("[^0-9]", "")));
				if(listOfData.get(0).getText().contains("Learn to interact with Elements"))
					System.out.println("Progress - Learn to interact with Elements : " + listOfData.get(1).getText());
			}
			
		}
		progress.sort(null);
		System.out.println(progress);
		
		for (WebElement row : listOfRows) {
			List<WebElement> listOfData = row.findElements(By.tagName("td"));
			if(listOfData != null && ! listOfData.isEmpty()) {
				if(listOfData.get(1).getText().contains(progress.get(0).toString())) {
					listOfData.get(2).findElement(By.tagName("input")).click(); 
					break;
				}
			}
		}
		
		File tempScreenShot = driver.getScreenshotAs(OutputType.FILE);
		File webTable = new File("./snaps/webTable.jpg");
		FileUtils.copyFile(tempScreenShot, webTable);
	}

}
