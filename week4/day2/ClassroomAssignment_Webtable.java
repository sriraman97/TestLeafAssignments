package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomAssignment_Webtable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement elementFromStation = driver.findElement(By.id("txtStationFrom"));
		elementFromStation.clear();
		elementFromStation.sendKeys("tpj",Keys.TAB);
		WebElement elementToStation = driver.findElement(By.id("txtStationTo"));
		elementToStation.clear();
		elementToStation.sendKeys("ms",Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		WebElement elementTrainTable = driver.findElement(By.xpath("(//div[@id='divTrainsList']/table)[1]"));
		List<WebElement> listOfRows = elementTrainTable.findElements(By.tagName("tr"));
		List<String> chennaiTrainNumbers = new ArrayList<String>();
		for (WebElement row : listOfRows) {
			List<WebElement> listOfDataPerRow = row.findElements(By.tagName("td"));
			if(listOfDataPerRow.get(1).getText().toLowerCase().contains("chennai")) {
				chennaiTrainNumbers.add(listOfDataPerRow.get(0).getText());
			}  
		}
		System.out.println(chennaiTrainNumbers);
	}

}
