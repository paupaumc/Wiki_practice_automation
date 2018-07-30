import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

public class WikiPractice {

	WebDriver driver; 

	public void validation() {
		
		By searchInput = By.xpath("//input[@id='searchInput']");
		By studioAlbumsInput = By.xpath("//*[@id=\"mw-content-text\"]/div/div[17]/table/tbody/tr[3]/td");
		By reputationInput = By.xpath("//*[@id=\"mw-content-text\"]/div/div[17]/table/tbody/tr[3]/td/div/ul/li[6]/i/a");
		By reputationPopUpInput = By.xpath("//*/div/div/a/p/text()");
	
		
		WebElement searchField = driver.findElement(searchInput);
		searchField.sendKeys("Taylor Swift");
		searchField.submit();
		
		WebElement studioAlbums = driver.findElement(studioAlbumsInput);
		String actualResult = studioAlbums.getText();
		String expectedResult = "Taylor Swift Fearless Speak Now Red 1989 Reputation";
		
		if(actualResult.equals(expectedResult)){System.out.println(true);
		}else {System.out.println(false);}
		
		WebElement reputationLink = driver.findElement(reputationInput);
		Actions action = new Actions(driver);
		action.moveToElement(reputationLink).perform();
		
		WebElement reputationPopUp = driver.findElement(reputationPopUpInput);	
		String actualResult1 = reputationPopUp.getText();
		String expectedResult1 = "is the sixth studio album by American singer and songwriter Taylor Swift. "
				+ "It was released on November 10, 2017, through Big Machine Records. "
				+ "The record was primarily produced by Jack Antonoff, Max Martin, Shellback and Swift herself, who also serves as the executive producer. "
				+ "Featured artists included on the album are English singer-songwriter Ed Sheeran and American rapper Future.";
		
		if(actualResult1.equals(expectedResult1)){System.out.println(true);
		}else {System.out.println(false);}
		
		
	}
	
	
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/paulinamunoz/Documents/Selenium Jars/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://en.wikipedia.org");
		driver.manage().window().maximize();
	}
	
	public void tearDown() {
		driver.close();
	}
	
	public static void main(String[] args) {
		WikiPractice test = new WikiPractice();
		test.setUp();
		test.validation();
		test.tearDown();
	}

}