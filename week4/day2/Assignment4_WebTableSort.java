package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_WebTableSort {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement elementWebTable = driver.findElement(By.id("table_id"));
		WebElement elementHeader = elementWebTable.findElement(By.tagName("thead"));
		WebElement elementBody = elementWebTable.findElement(By.tagName("tbody"));
		List<WebElement> listOfRows = elementBody.findElements(By.tagName("tr"));
		List<String> listOfNames = new ArrayList<String>();
		List<String> listOfSortedNames = new ArrayList<String>();
		
		for (WebElement row : listOfRows) {
			List<WebElement> listOfColumns = row.findElements(By.tagName("td"));
			listOfNames.add(listOfColumns.get(1).getText());
		}
		listOfNames.sort(null);
		elementHeader.findElement(By.xpath("(//th[@class='sorting'])[1]")).click(); //click on name to sort
		
		File tempScreenShot = driver.getScreenshotAs(OutputType.FILE);
		File sortTable = new File("./snaps/sortTable.jpg");
		FileUtils.copyFile(tempScreenShot, sortTable);
		
		for (WebElement row : listOfRows) {
			List<WebElement> listOfColumns = row.findElements(By.tagName("td"));
			listOfSortedNames.add(listOfColumns.get(1).getText());
		}
		System.out.println("List of names: " + listOfNames);
		System.out.println("List of sorted names: " + listOfSortedNames);
		int i = 0; 
		boolean isSorted = true;
		while(i < listOfNames.size()) {
			if(! listOfNames.get(i).equals(listOfSortedNames.get(i))) {
				isSorted = false; 
				break;
			}
			i++;
		}
		System.out.println(isSorted ? "Names are sorted" : "Names are not sorted");
	}

}
