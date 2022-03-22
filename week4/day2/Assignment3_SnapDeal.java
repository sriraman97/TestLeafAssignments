package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3_SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions builder = new Actions(driver);		
		builder.moveToElement(driver.findElement(By.xpath("(//a[@class='menuLinks leftCategoriesProduct '])[1]"))).perform(); //mouse over Men's fashion
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click(); //click on sports shoes
		System.out.println("Count = " + driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText().replaceAll("[^0-9]", "")); //get the count of result
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click(); //click on training shoes
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click(); //click on sort by
		WebElement elementUlSortValue = driver.findElement(By.xpath("//ul[@class='sort-value']"));
		List<WebElement> listOfSortValues = elementUlSortValue.findElements(By.tagName("li"));
		for (WebElement sortValue : listOfSortValues) {
			if(sortValue.getText().contains("Price Low To High")) { //sort by low to high
				sortValue.click(); break;
			}
		}
		List<WebElement> elementListOfPrice;
		try {
			elementListOfPrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']")); //get the list of price
			isPriceSorted(elementListOfPrice);
		}
		catch(StaleElementReferenceException e) {
			
			elementListOfPrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']")); //get the list of price
			isPriceSorted(elementListOfPrice);
		}
				
		WebElement elementPriceRangeFrom = driver.findElement(By.name("fromVal"));
		WebElement elementPriceRangeTo = driver.findElement(By.name("toVal"));
		
		elementPriceRangeFrom.clear();
		elementPriceRangeFrom.sendKeys("900"); //set price range from 900 to 1200
		
		elementPriceRangeTo.clear();
		elementPriceRangeTo.sendKeys("1200");
		
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();//click on GO button
		
		/*
		 * driver.findElement(By.xpath("(//button[text()='View More '])[3]")).click();
		 * //click on view more (color) WebElement elementNavy = driver.findElement(By.
		 * xpath("(//div[@class='sdCheckbox filters-list ']//a[contains(text(),'Navy')])[1]"
		 * )); //select navy color elementNavy.click();
		 * builder.moveToElement(elementNavy).click().perform();
		 */
		
		WebElement elementProductName = driver.findElement(By.xpath("//p[@class='product-title']"));
		builder.moveToElement(elementProductName).perform();
		WebElement elementQuickView = driver.findElement(By.xpath("//div[@class='clearfix row-disc']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(elementQuickView));
		elementQuickView.click();
		
		System.out.println("Cost: " + driver.findElement(By.xpath("(//div[@class='product-price pdp-e-i-PAY-l clearfix']/span)[1]")).getText());
		System.out.println("Discount: " + driver.findElement(By.xpath("(//div[@class='product-price pdp-e-i-PAY-l clearfix']/span)[1]")).getText()); //  //span[@class='percent-desc ']
		
		File tempScreenshot = driver.getScreenshotAs(OutputType.FILE);
		File snapDealProduct = new File("./snaps/snapDeal.jpg");
		FileUtils.copyFile(tempScreenshot, snapDealProduct);
		
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click(); //closes  (Quick view)
		driver.close();
	}
	
	public static void isPriceSorted(List<WebElement> elementListOfPrice) {
		List<Integer> listOfPrice = new ArrayList<Integer>();
		
		for (WebElement price : elementListOfPrice) {
			String onlyNumbers = price.getText().replaceAll("[^0-9]", "");
			listOfPrice.add(Integer.parseInt(onlyNumbers));	
		}

		int i = 0; 
		boolean isSorted = true;
		while(i < listOfPrice.size()-1) { //check if the price is sorted
			if(! (listOfPrice.get(i) <= listOfPrice.get(i+1))) {
				isSorted = false; 
				break;
			}
			i++;
		}
		System.out.println(isSorted ? "Price sorted": "Price Not sorted");

	}

}
